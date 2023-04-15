package org.example.exercicio20;

import java.util.ArrayList;

public class Pedido {
    private ArrayList<Item> listaDeItens = new ArrayList<>();
    private double valorTotalDoPedido = 0;

    public void calculaValorTotal() {
        for(Item item : listaDeItens) {
            valorTotalDoPedido += item.defineValorTotal();
        }
    }

    public boolean adicionaItemNaLista(Produto produto, int quantidade) throws IllegalArgumentException {
        for(Item item : listaDeItens)
            if(item.getProduto().getNome().equals(produto.getNome())) {
                item.setQuantidade(item.getQuantidade() + quantidade);
                return true;
            }
        Item item = new Item(produto, quantidade);
        listaDeItens.add(item);
        return true;
    }

    public void imprimePedido() {
        if(listaDeItens.size() == 0)
            System.out.println("Lista vazia");
        StringBuilder sb = new StringBuilder();
        sb.append("Pedido:\n");
        for(Item item : listaDeItens)
            sb.append(item.getQuantidade())
                    .append("x ")
                    .append(item.getProduto().getNome())
                    .append(", por: ")
                    .append(item.defineValorTotal())
                    .append("\n");
        System.out.println(sb.toString());
    }

    public void imprimeValorTotal() {
        System.out.println("O valor total é: " + getValorTotalDoPedido());
    }

    //TODO
    public String recebeNomeDoTeclado() {
        return "";
    }

    //TODO
    public int recebeQuantidadeDoTeclado() {
        return 0;
    }

    public void limparCarrinho() {
        listaDeItens = new ArrayList<>();
    }

    public ArrayList<Item> getListaDeItens() {
        return listaDeItens;
    }

    public void setListaDeItens(ArrayList<Item> listaDeItens) {
        this.listaDeItens = listaDeItens;
    }

    public double getValorTotalDoPedido() {
        return valorTotalDoPedido;
    }

    public void setValorTotalDoPedido(double valorTotalDoPedido) {
        this.valorTotalDoPedido = valorTotalDoPedido;
    }
}