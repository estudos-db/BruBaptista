package org.example.exercicio20;

public class Main {
    public static void main(String[] args) {
        Estoque estoque = new Estoque();
        Produto a = new Produto("a", 10, 2);
        estoque.cadastraProduto(a);
        //Menu menuEstoque = new Menu(estoque);
        //menuEstoque.controlaMenuEstoque();

        Pedido pedido = new Pedido();
        Menu menuPedido = new Menu(pedido);
        menuPedido.controlaMenuPedido();
    }
}