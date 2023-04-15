package org.example.exercicio20;

public class Produto {
    private int id;
    private String nome;
    private double preco;
    private int quantidadeEmEstoque;

    public Produto(int id, String nome, double preco, int quantidadeEmEstoque) {
        this.id = id;
        this.nome = nome;
        this.setPreco(preco);
        this.setQuantidadeEmEstoque(quantidadeEmEstoque);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if(preco <= 0)
            throw new IllegalArgumentException("Preço inválido");
        this.preco = preco;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        if(quantidadeEmEstoque <= 0)
            throw new IllegalArgumentException("Qauntidade inválida");
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }
}
