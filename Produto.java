public class Produto {
    private int codigo;
    private String descricao;
    private double preco;
    private int saldo;
    private int pontoDeAlarme;
    private boolean emFalta;
    
    public Produto (int cod, String desc){
        this.codigo = cod;
        this.descricao = desc;
        this.preco = 0;
        this.saldo = 0;
        this.pontoDeAlarme = 1;
        this.emFalta = true;
    }
    
    public int getCodigo(){
        return this.codigo;
    }
    
    public String getDescricao(){
        return this.descricao;
    }
    
    public double getPreco(){
        return this.preco;
    }
    
    public int getSaldo(){
        return this.saldo;
    }
    
    public int getPontoDeAlarme(){
        return this.pontoDeAlarme;
    }
    
    public boolean getEmFalta(){
        return this.emFalta;
    }
    
    public boolean abastece (int qtd, double precoCompra){
        if (this.emFalta){
            this.saldo += qtd;
            if (this.saldo >= this.pontoDeAlarme){
                this.emFalta = false;
            }
            
            if (qtd >= 6){
                this.preco = precoCompra + precoCompra*0.2;
            } else if (qtd < 3){
                this.preco = precoCompra + precoCompra*0.35;
            } else {
                this.preco = precoCompra + precoCompra*0.25;
            }
            
            if (qtd > 5){
                this.pontoDeAlarme = (int)(qtd*0.2);
            }
            
            return true;
        } else {
            return false;
        }
    }
    
    public int baixaEstoque (int qtd){
        if (this.saldo >= qtd){
            this.saldo -= qtd;
            if (this.saldo <= this.pontoDeAlarme){
                this.emFalta = true;
                return 2;
            } else {
                return 3;
            }
        } else {
            return 1;
        }
    }
    
    public void estornaBaixaEstoque (int qtd){
        this.saldo += qtd;
        if (this.saldo >= this.pontoDeAlarme){
            this.emFalta = false;
        }
    }
}