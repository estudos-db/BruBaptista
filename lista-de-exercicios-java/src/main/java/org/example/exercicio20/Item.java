package org.example.exercicio20;

public class Item {
    private final Produto produto;
    private int quantidade;
    private final double valorDoItem;

    public Item(Produto produto, int quantidade) {
        this.produto = produto;
        this.setQuantidade(quantidade);
        this.valorDoItem = produto.getPreco();
    }

    public double defineValorTotal() {
        return this.valorDoItem * this.quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        if(quantidade <= 0)
            throw new IllegalArgumentException("Quantidade inválida");
        this.quantidade = quantidade;
    }
}
