package org.example.exercicio02;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Produto {
    private String nome;
    private BigDecimal preco;
    private int quantidade;

    public Produto(String nome, BigDecimal preco, int quantidade) {
        this.nome = nome;
        validarPreco(preco);
        this.preco = preco;
        validarQuantidade(quantidade);
        this.quantidade = quantidade;
    }

    private BigDecimal validarPreco(BigDecimal preco) {
        if (preco.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Preço inválido.");
        }
        return preco;
    }

    private int validarQuantidade(int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade inválida.");
        }
        return quantidade;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void aumentarQuantidade(int quantidade) {
        validarQuantidade(quantidade);
        this.quantidade += quantidade;
    }

    public void diminuirQuantidade(int quantidade) {
        validarQuantidade(quantidade);
        if (this.quantidade >= quantidade)
            this.quantidade -= quantidade;
        else
            throw new IllegalArgumentException("Quantidade insuficiente em estoque.");
    }

    public BigDecimal getPreco() {
        BigDecimal precoParcial = preco.multiply(new BigDecimal(quantidade));
        BigDecimal precoComDesconto = getDesconto(precoParcial);
        return precoComDesconto.setScale(2, RoundingMode.HALF_UP);
    }

    private BigDecimal getDesconto(BigDecimal precoParcial) {
        BigDecimal desconto = BigDecimal.ZERO;
        if(this.quantidade > 50)
            desconto = precoParcial.multiply(new BigDecimal(0.25));
        else if(this.quantidade >= 21)
            desconto = precoParcial.multiply(new BigDecimal(0.20));
        else if(this.quantidade >= 11) {
            desconto = precoParcial.multiply(new BigDecimal(0.10));
        }
        BigDecimal precoComDesconto = precoParcial.subtract(desconto);
        return precoComDesconto;
    }

    public String getProduto() {
        return "Você está comprando " + getQuantidade() + " unidades de " + getNome() +
                " pelo valor de " + getPreco() + " reais";
    }
}
