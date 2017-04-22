public class TestaPedido {
    public static void main (String[] args){
        Teclado t = new Teclado();
        Cliente c1,c2;
        Produto p1,p2,p3,p4;
        Pedido ped1,ped2,ped3,ped4;
        int resBaixa,qtdBaixa;
        String statusBaixa = "";

        //alternar comentarios nas linhas abaixo de #manual e #automatico

        //Intancia clientes
        //c1 = new Cliente(t.leString("Digite o nome do primeiro cliente:"));  // #manual
        //c2 = new Cliente(t.leString("Digite o nome do segundo cliente:"));  // #manual

        c1 = new Cliente("Rafael"); // #automatico
        c2 = new Cliente("Fabiane"); // #automatico

        //lista clientes instanciados
        System.out.println("Cliente: " + c1.getCodigoID() + " Nome: " + c1.getNome());
        System.out.println("Cliente: " + c2.getCodigoID() + " Nome: " + c2.getNome());

        //instancia produto 1
        p1 = new Produto(1,"Caneta"); // #automatico
        //p1 = new Produto(1,t.leString("Digite a descricao do produto 1:")); // #manual

        System.out.println("Inserido produto " + p1.getCodigo() + ": " + p1.getDescricao());
        //abastece produto 1
        p1.abastece(1000,10); // #automatico
        //p1.abastece(t.leInt("Efetuando entrada. Digite a quantidade:"), t.leDouble("Preco:")); #manual
        //lista saldo produto 1
        System.out.println("Quantidade em estoque: " + p1.getSaldo());

        qtdBaixa = 1650; // #automatico
        //qtdBaixa = t.leInt("Efetuando baixa, digite a quantidade:"); // #manual
        //testa retorno do status da baixa
        resBaixa = p1.baixaEstoque(qtdBaixa);
        if (resBaixa == 1){
            statusBaixa = "Saldo insuficiente!";
        } else {
            statusBaixa = "Baixa efetuada!";
        }
        System.out.println("Baixa de " + qtdBaixa + " unidades. Status: " + resBaixa + " - " + statusBaixa + " Produto em falta: " + p1.getEmFalta());
        //apresenta saldo
        System.out.println("Quantidade em estoque: " + p1.getSaldo());

        //instancia produto 2
        p2 = new Produto(2,"Bola"); // #automatico
        //p2 = new Produto(1,t.leString("Digite a descricao do produto 2:")); // #manual

        System.out.println("Inserido produto " + p2.getCodigo() + ": " + p2.getDescricao());
        //abastece produto 2
        p2.abastece(2000,50); // #automatico
        //p2.abastece(t.leInt("Efetuando entrada. Digite a quantidade:"), t.leDouble("Preco:")); #manual
        //apresenta saldo produto 2
        System.out.println("Quantidade em estoque: " + p2.getSaldo());

        qtdBaixa = 1650; // #automatico
        //qtdBaixa = t.leInt("Efetuando baixa, digite a quantidade:"); // #manual

        //testa retorno do status da baixa
        resBaixa = p2.baixaEstoque(qtdBaixa);
        if (resBaixa == 1){
            statusBaixa = "Saldo insuficiente!";
        } else {
            statusBaixa = "Baixa efetuada!";
        }
        System.out.println("Baixa de " + qtdBaixa + " unidades. Status: " + resBaixa + " - " + statusBaixa + " Produto em falta: " + p2.getEmFalta());
        System.out.println("Quantidade em estoque: " + p2.getSaldo());

        p3 = new Produto(3,"Celular"); // #automatico
        //p3 = new Produto(1,t.leString("Digite a descricao do produto 3:")); // #manual

        System.out.println("Inserido produto " + p3.getCodigo() + ": " + p3.getDescricao());
        // abastece produto 3
        p3.abastece(4,100); // #automatico
        //p3.abastece(t.leInt("Efetuando entrada. Digite a quantidade:"), t.leDouble("Preco:")); #manual

        System.out.println("Quantidade em estoque: " + p3.getSaldo());

        qtdBaixa = 1; // #automatico
        //qtdBaixa = t.leInt("Efetuando baixa, digite a quantidade:"); // #manual

        //testa retorno do status da baixa
        resBaixa = p3.baixaEstoque(qtdBaixa);
        if (resBaixa == 1){
            statusBaixa = "Saldo insuficiente!";
        } else {
            statusBaixa = "Baixa efetuada!";
        }
        System.out.println("Baixa de " + qtdBaixa + " unidade. Status: " + resBaixa + " - " + statusBaixa + " Produto em falta: " + p3.getEmFalta());
        System.out.println("Quantidade em estoque: " + p3.getSaldo());

        //instancia produto 4
        p4 = new Produto(1,"Inseticida"); // #automatico
        //p4 = new Produto(1,t.leString("Digite a descricao do produto 1:")); // #manual

        System.out.println("Inserido produto " + p4.getCodigo() + ": " + p4.getDescricao());
        //abastece produto 4
        p4.abastece(500,10); // #automatico
        //p4.abastece(t.leInt("Efetuando entrada. Digite a quantidade:"), t.leDouble("Preco:")); #manual
        //apresenta saldo produto 4
        System.out.println("Quantidade em estoque: " + p4.getSaldo());

        qtdBaixa = 500; // #automatico
        //qtdBaixa = t.leInt("Efetuando baixa, digite a quantidade:"); // #manual

        //testa retorno do status da baixa
        resBaixa = p4.baixaEstoque(qtdBaixa);
        if (resBaixa == 1){
            statusBaixa = "Saldo insuficiente!";
        } else {
            statusBaixa = "Baixa efetuada!";
        }
        System.out.println("Baixa de " + qtdBaixa + " unidades. Status: " + resBaixa + " - " + statusBaixa + " Produto em falta: " + p4.getEmFalta());
        System.out.println("Quantidade em estoque: " + p4.getSaldo());

        //instancia pedidos
        ped1 = new Pedido(1);
        ped2 = new Pedido(2,c1);
        ped3 = new Pedido(3,c1);
        ped4 = new Pedido(4,c1);

        //faz entradas de produtos testando alerta de "em falta"
        System.out.println("Inserindo 200 " + p1.getDescricao());
        System.out.println(ped1.insereProduto(p1,200));
        System.out.println("Inserindo 150 " + p2.getDescricao());
        System.out.println(ped1.insereProduto(p2,150));
        System.out.println("Inserindo 1 " + p3.getDescricao());
        System.out.println(ped1.insereProduto(p3,1));
        System.out.println("Inserindo 50 " + p4.getDescricao());
        System.out.println(ped1.insereProduto(p4,50));

        //apresenta pedido sem cliente
        ped1.exibePedido();
        // testa fechar pedido sem cliente
        System.out.println("Fechando Pedido 1..." + ped1.fechaPedido());

        ped1.setCliente(c1);
        System.out.println("Cliente " + c1.getCodigoID() + " adicionado ao Pedido 1");

        System.out.println("Fechando Pedido 1..." + ped1.fechaPedido());
        //apresenta pedido fechado
        ped1.exibePedido();

        //apresenta atributos do cliente
        System.out.println("Cliente " + c1.getCodigoID() + ":");
        System.out.println("Nome:                 " + c1.getNome() + ":");
        System.out.println("Maior compra:         " + c1.getValorMaiorCompra() + ":");
        System.out.println("Segunda maior compra: " + c1.getValorSegMaiorCompra() + ":");
        System.out.println("Pedidos feitos:       " + c1.getQtdPedidosFeitos() + ":");

        //apresenta saldo
        System.out.println("\n\nQuantidade em estoque:");
        System.out.println(p1.getDescricao() + ": " + p1.getSaldo() + " Ponto de alarme: " + p1.getPontoDeAlarme() + " Em falta: " + p1.getEmFalta());
        System.out.println(p2.getDescricao() + ": " + p2.getSaldo() + " Ponto de alarme: " + p2.getPontoDeAlarme() + " Em falta: " + p2.getEmFalta());
        System.out.println(p3.getDescricao() + ": " + p3.getSaldo() + " Ponto de alarme: " + p3.getPontoDeAlarme() + " Em falta: " + p3.getEmFalta());

        System.out.println("Inserindo 50 " + p4.getDescricao());
        System.out.println(ped2.insereProduto(p4,50));
        System.out.println("Inserindo 300 " + p2.getDescricao());
        System.out.println(ped2.insereProduto(p2,300));
        System.out.println("Inserindo 200 " + p2.getDescricao());
        System.out.println(ped2.insereProduto(p2,200));
        System.out.println("Inserindo 300 " + p1.getDescricao());
        System.out.println(ped2.insereProduto(p1,300));

        ped2.exibePedido();

        if (ped2.enviaParaEntrega()){
            System.out.println("Pedido enviado para entrega");
        } else {
            System.out.println("Nâo foi possível enviar para entrega");
        }

        System.out.println("Fechando Pedido 2..." + ped2.fechaPedido());

        ped2.exibePedido();

        if (ped2.enviaParaEntrega()){
            System.out.println("Pedido enviado para entrega");
        } else {
            System.out.println("Nâo foi possível enviar para entrega");
        }

        ped2.exibePedido();


        //apresenta atributos do cliente
        System.out.println("Cliente " + c1.getCodigoID() + ":");
        System.out.println("Nome:                 " + c1.getNome() + ":");
        System.out.println("Maior compra:         " + c1.getValorMaiorCompra() + ":");
        System.out.println("Segunda maior compra: " + c1.getValorSegMaiorCompra() + ":");
        System.out.println("Pedidos feitos:       " + c1.getQtdPedidosFeitos() + ":");

        System.out.println("\n\nQuantidade em estoque:");
        System.out.println(p1.getDescricao() + ": " + p1.getSaldo() + " Ponto de alarme: " + p1.getPontoDeAlarme() + " Em falta: " + p1.getEmFalta());
        System.out.println(p2.getDescricao() + ": " + p2.getSaldo() + " Ponto de alarme: " + p2.getPontoDeAlarme() + " Em falta: " + p2.getEmFalta());
        System.out.println(p3.getDescricao() + ": " + p3.getSaldo() + " Ponto de alarme: " + p3.getPontoDeAlarme() + " Em falta: " + p3.getEmFalta());


        System.out.println("Inserindo 50 " + p4.getDescricao());
        System.out.println(ped3.insereProduto(p4,50));
        System.out.println("Inserindo 300 " + p2.getDescricao());
        System.out.println(ped3.insereProduto(p2,300));
        System.out.println("Inserindo 200 " + p2.getDescricao());
        System.out.println(ped3.insereProduto(p2,200));
        System.out.println("Inserindo 300 " + p1.getDescricao());
        System.out.println(ped3.insereProduto(p1,300));

        ped3.exibePedido();

        if (ped3.cancelaPedido()){
            System.out.println("Pedido cancelado");
        } else {
            System.out.println("Nâo foi possível cancelar o pedido");
        }

        ped3.exibePedido();

        System.out.println("\n\nQuantidade em estoque:");
        System.out.println(p1.getDescricao() + ": " + p1.getSaldo() + " Ponto de alarme: " + p1.getPontoDeAlarme() + " Em falta: " + p1.getEmFalta());
        System.out.println(p2.getDescricao() + ": " + p2.getSaldo() + " Ponto de alarme: " + p2.getPontoDeAlarme() + " Em falta: " + p2.getEmFalta());
        System.out.println(p3.getDescricao() + ": " + p3.getSaldo() + " Ponto de alarme: " + p3.getPontoDeAlarme() + " Em falta: " + p3.getEmFalta());

        p1.abastece(1000,10);
        p2.abastece(1000,10);
        p3.abastece(1000,10);
        p4.abastece(1000,10);

        System.out.println("\n\nQuantidade em estoque:");
        System.out.println(p1.getDescricao() + ": " + p1.getSaldo() + " Ponto de alarme: " + p1.getPontoDeAlarme() + " Em falta: " + p1.getEmFalta());
        System.out.println(p2.getDescricao() + ": " + p2.getSaldo() + " Ponto de alarme: " + p2.getPontoDeAlarme() + " Em falta: " + p2.getEmFalta());
        System.out.println(p3.getDescricao() + ": " + p3.getSaldo() + " Ponto de alarme: " + p3.getPontoDeAlarme() + " Em falta: " + p3.getEmFalta());


        //faz entradas de produtos Pedido de teste de desconto
        System.out.println("Inserindo 200 " + p1.getDescricao());
        System.out.println(ped4.insereProduto(p1,500));
        System.out.println("Inserindo 150 " + p2.getDescricao());
        System.out.println(ped4.insereProduto(p2,500));
        System.out.println("Inserindo 1 " + p3.getDescricao());
        System.out.println(ped4.insereProduto(p3,500));
        System.out.println("Inserindo 50 " + p4.getDescricao());
        System.out.println(ped4.insereProduto(p4,500));

        //apresenta pedido sem cliente
        ped4.exibePedido();
        // testa fechar pedido sem cliente
        System.out.println("Fechando Pedido 1..." + ped4.fechaPedido());

        ped4.setCliente(c1);
        System.out.println("Cliente " + c1.getCodigoID() + " adicionado ao Pedido 1");

        System.out.println("Fechando Pedido 1..." + ped4.fechaPedido());
        //apresenta pedido fechado
        ped4.exibePedido();

        //apresenta atributos do cliente
        System.out.println("Cliente " + c1.getCodigoID() + ":");
        System.out.println("Nome:                 " + c1.getNome() + ":");
        System.out.println("Maior compra:         " + c1.getValorMaiorCompra() + ":");
        System.out.println("Segunda maior compra: " + c1.getValorSegMaiorCompra() + ":");
        System.out.println("Pedidos feitos:       " + c1.getQtdPedidosFeitos() + ":");

        //apresenta saldo
        System.out.println("\n\nQuantidade em estoque:");
        System.out.println(p1.getDescricao() + ": " + p1.getSaldo() + " Ponto de alarme: " + p1.getPontoDeAlarme() + " Em falta: " + p1.getEmFalta());
        System.out.println(p2.getDescricao() + ": " + p2.getSaldo() + " Ponto de alarme: " + p2.getPontoDeAlarme() + " Em falta: " + p2.getEmFalta());
        System.out.println(p3.getDescricao() + ": " + p3.getSaldo() + " Ponto de alarme: " + p3.getPontoDeAlarme() + " Em falta: " + p3.getEmFalta());
    }
}
