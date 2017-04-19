public class Cliente{
    private String codigoID;
    private String nome;
    private double valorMaiorCompra;
    private double valorSegMaiorCompra;
    private int qtdPedidosFeitos;
    
    public Cliente(String nomeCli){
        this.codigoID = defineCodigo(nomeCli);
        this.nome = nomeCli;
        this.valorMaiorCompra = 0;
        this.valorSegMaiorCompra = 0;
        this.qtdPedidosFeitos = 0;
    }
    
    private String defineCodigo(String nomeCliente){
        return nomeCliente.toUpperCase().substring(0,3);
    }
    
    public void registraPedido(double valorFinal){
        this.qtdPedidosFeitos ++;
        
        if (valorFinal >= this.valorMaiorCompra){
            this.valorSegMaiorCompra = this.valorMaiorCompra;
            this.valorMaiorCompra = valorFinal;
        } else if (valorFinal > this.valorSegMaiorCompra){
            this.valorSegMaiorCompra = valorFinal;
        }
    }
    
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
