/**Alunos: Fabiane Kuhn e Rafael Corrêa      Turma: 71    Trabalho GA   Lab1   2017/1*/
public class Cliente{
//Atributos
    private String codigoID;
    private String nome;
    private double valorMaiorCompra;
    private double valorSegMaiorCompra;
    private int qtdPedidosFeitos;
//Atributos
    public Cliente(String nomeCli){
        this.codigoID = defineCodigo(nomeCli);
        this.nome = nomeCli;
        this.valorMaiorCompra = 0;
        this.valorSegMaiorCompra = 0;
        this.qtdPedidosFeitos = 0;
    }
//Método para definir o código do cliente considerando as três primeiras letras do nome e um valor aleatório entre 100 e 999   
    private String defineCodigo(String nomeCliente){
//Se o nome do cliente possuir menos de três caracteres completa com espaços
        while (nomeCliente.length() < 3){
            nomeCliente = nomeCliente + " ";
        }
        int numRand = 100 + (int) (Math.random() * 999);
        return nomeCliente.toUpperCase().substring(0,3)+numRand;
    }
//Método para registrar o pedido feito para o cliente    
    public void registraPedido(double valorFinal){
        this.qtdPedidosFeitos ++;
        if (valorFinal >= this.valorMaiorCompra){
            this.valorSegMaiorCompra = this.valorMaiorCompra;
            this.valorMaiorCompra = valorFinal;
        } else if (valorFinal > this.valorSegMaiorCompra){
            this.valorSegMaiorCompra = valorFinal;
        }
    }
//Métodos de acesso aos atributos 
    public String getCodigoID(){
        return this.codigoID;
    }
    public String getNome(){
        return this.nome;
    }
    public double getValorMaiorCompra(){
        return this.valorMaiorCompra;
    }
    public double getValorSegMaiorCompra(){
        return this.valorSegMaiorCompra;
    }
    public int getQtdPedidosFeitos(){
        return this.qtdPedidosFeitos;
    }
}
