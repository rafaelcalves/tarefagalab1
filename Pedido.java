/**Alunos: Fabiane Kuhn e Rafael Corrêa      Turma: 71    Trabalho GA   Lab1   2017/1*/
public class Pedido {
//Atributos    
    private int numero;
    private Cliente cliente;
    private Produto p1;
    private Produto p2;
    private Produto p3;
    private int quant1;
    private int quant2;
    private int quant3;
    private double valorTotal;
    private double desconto;
    private double valorFinal;
    private int situacao;
//Construtores
    public Pedido(int numPed, Cliente cli){
        this.numero = numPed;
        this.cliente = cli;
        this.p1 = null;
        this.p2 = null;
        this.p3 = null;
        this.quant1 = 0;
        this.quant2 = 0;
        this.quant3 = 0; 
        this.valorTotal = 0;
        this.desconto = 0;
        this.valorFinal = 0;
        this.situacao = 1;
    }
    public Pedido (int numeroPed){
        this.numero = numeroPed;
        this.cliente = null;
        this.p1 = null;
        this.p2 = null;
        this.p3 = null;
        this.quant1 = 0;
        this.quant2 = 0;
        this.quant3 = 0; 
        this.valorTotal = 0;
        this.desconto = 0;
        this.valorFinal = 0;
        this.situacao = 1;        
    }
//Método para inserir um produto
    public String insereProduto(Produto pro, int qtd){
//Verifica se a situação é de pedido aberto
        if (this.situacao != 1){
            return "Situação não permite inserção de produto";
        }
//Verifica se o pedido já possui três produtos
        if (this.quant1 > 0 && this.quant2 > 0 && this.quant3 > 0){
            return "Pedido não comporta mais produtos";
        }
//Realiza a baixa do estoque e calcula o valor total do pedido 
        if (this.quant1 == 0){
            this.p1 = pro;
//Variável auxiliar para o retorno da baixa de estoque
            int returnP1 = p1.baixaEstoque(qtd);
            if (returnP1 == 1)
                return "Saldo insuficiente";
            else if (returnP1 == 2){
                this.valorTotal += p1.getPreco() * qtd;
//Carrega o valor final do pedido
                this.valorFinal = this.valorTotal;                
                this.quant1 = qtd;
                return "Produto inserido com alarme no estoque";
            }else if (returnP1 == 3){
                this.valorTotal += p1.getPreco() * qtd;
//Carrega o valor final do pedido
                this.valorFinal = this.valorTotal;                
                this.quant1 = qtd;                
                return "Produto inserido";
            }
        }else if (this.quant2 == 0){
            this.p2 = pro;
//Variável auxiliar para o retorno da baixa de estoque                
            int returnP2 = p2.baixaEstoque(qtd);
            if (returnP2 == 1)
                return "Saldo insuficiente";
            else if (returnP2 == 2){
                this.valorTotal += p2.getPreco() * qtd;
//Carrega o valor final do pedido
                this.valorFinal = this.valorTotal;                
                this.quant2 = qtd;                
                return "Produto inserido com alarme no estoque";
            }else if (returnP2 == 3){
                this.valorTotal += p2.getPreco() * qtd;
//Carrega o valor final do pedido
                this.valorFinal = this.valorTotal;                
                this.quant2 = qtd;                
                return "Produto inserido";
            }
        }else{
            this.p3 = pro;
//Variável auxiliar para o retorno da baixa de estoque                
            int returnP3 = p3.baixaEstoque(qtd);
            if (returnP3 == 1)
                return "Saldo insuficiente";
            else if (returnP3 == 2){
                this.valorTotal += p3.getPreco() * qtd; 
//Carrega o valor final do pedido
                this.valorFinal = this.valorTotal;                
                this.quant3 = qtd;                
                return "Produto inserido com alarme no estoque";
            }else if (returnP3 == 3){
                this.valorTotal += p3.getPreco() * qtd;    
//Carrega o valor final do pedido
                this.valorFinal = this.valorTotal;                
                this.quant3 = qtd;                
                return "Produto inserido";
            }
        }
        return "Falha na rotina de inserção de pedido";
    }
//Método para fechar o pedido    
    public String fechaPedido(){
        if (this.situacao != 1){
            return "Situação atual não permite esta operação";
        }
//Se o pedido não possui nenhum pedido informado
//Obs.: É possível testar apenas a quantidade do primeiro produto, visto que a inserção de itens no pedido é feita sempre no atributo "mais baixo"  
        if (this.quant1 == 0){
            return "Não pode fechar pedido sem pelo menos um produto";
        }
//Verifica se pode haver desconto no pedido
        if ((this.valorTotal > 500) && (cliente.getQtdPedidosFeitos() >= 2)){
//Desconto de 5% se o pedido apresentar um valor superior a maior compra do cliente            
            if (this.valorTotal > cliente.getValorMaiorCompra()){
                this.desconto = this.valorTotal * 0.05;
                this.valorFinal -= this.desconto;
            }else{
//Desconto de 3,5% para valor superior a segunda maior compra do cliente
                if (this.valorTotal > cliente.getValorSegMaiorCompra()){
                    this.desconto = this.valorTotal * 0.035;
                    this.valorFinal -= this.desconto;
                }
            }
        }
//Registra o pedido para o cliente
        cliente.registraPedido(this.valorFinal);
//Fecha o pedido
        this.situacao = 2;
        return "Pedido fechado";
    }    
//Método para enviar para entrega
    public boolean enviaParaEntrega(){
        if (this.situacao != 2){
            return false;
        }
        this.situacao = 3;
        return true;
    }
//Método para exibir o pedido
    public void exibePedido(){
        if (quant1 == 0){
            System.out.printf("Pedido número: "+this.numero+"\nPedido sem nenhum item incluído");
        }else{   
        int seq = 1;
        System.out.printf("Pedido núm "+this.numero);
        if (cliente != null){
            System.out.printf("\t\t\t\t\tNome do cliente: "+cliente.getNome());
        }
        System.out.printf("\n------------------------------------Produtos inseridos-------------------------------");
        System.out.printf("\nSeq.\tQuant\tCódigo\tDescrição\t\t\tPreço unit\tPreço total");
        System.out.printf("\n--------------------------------------------------------------------------------------");
        if (quant1 > 0){
            System.out.printf("\n"+seq+"\t"+this.quant1+"\t"+p1.getCodigo()+"\t"+p1.getDescricao()+"\t\t\t"+p1.getPreco()+"\t\t"+(p1.getPreco() * quant1)+"\n");
        }
        if (quant2 > 0){
            seq++;
            System.out.printf("\n"+seq+"\t"+this.quant2+"\t"+p2.getCodigo()+"\t"+p2.getDescricao()+"\t\t\t"+p2.getPreco()+"\t\t"+(p2.getPreco() * quant2)+"\n");
        }
        if (quant3 > 0){
            seq++;
            System.out.printf("\n"+seq+"\t"+this.quant3+"\t"+p3.getCodigo()+"\t"+p3.getDescricao()+"\t\t\t"+p3.getPreco()+"\t\t"+(p3.getPreco() * quant3)+"\n");
        }
        System.out.printf("------------------------------------------------------------------------------------");
        System.out.printf("\n\t\t\t\t\t\t\t\tValor total: R$ "+this.valorTotal);
        //Apenas apresenta a linha de desconto se possui desconto no pedido
        if (this.desconto > 0){
            System.out.printf("\n\t\t\t\t\t\t\t\tDesconto: R$ "+this.desconto);
        }
        System.out.printf("\n\t\t\t\t\t\t\t\tValor final: R$ "+this.valorFinal);
//Declara variável auxiliar para a situação do pedido
        String sit;
        switch (situacao){
            case 1:
                sit = "aberto";
                break;
            case 2:
                sit = "fechado";
                break;
            case 3:
                sit = "enviado";
                break;
            case 4:
                sit = "cancelado";
                break;
            default:
                sit = "inválido";
        }
        System.out.printf("\nSituação: "+sit);        
    }
    }
//Método para cancelar pedido
//Obs.: No diagrama UML entregue esse método estava com declaração VOID, porém, percebemos a necessidade da alteração para boolean
    public boolean cancelaPedido(){
        if (this.situacao !=1){
            return false;
        }
        this.situacao = 4;
        if (this.p1 != null){
            p1.estornaBaixaEstoque(this.quant1);
        }
        if (this.p2 != null){
            p2.estornaBaixaEstoque(this.quant2);
        }
        if (this.p3 != null){
            p3.estornaBaixaEstoque(this.quant3);
        }
        return true;
    }

//Métodos de acesso aos atributos
//Métodos de alteração dos atributos

}
        
            
