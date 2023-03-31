package org.example.exercicio02;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Produto mouse = new Produto("mouse", new BigDecimal(7.99), 1);
        System.out.println(mouse.getProduto());

        mouse.aumentarQuantidade(10);
        System.out.println(mouse.getProduto());

        mouse.aumentarQuantidade(10);
        System.out.println(mouse.getProduto());

        mouse.aumentarQuantidade(30);
        System.out.println(mouse.getProduto());
    }
}
