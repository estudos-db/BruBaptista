package org.example.exercicio20;

public class Main {
    public static void main(String[] args) {
        Estoque estoque = new Estoque();
        Produto a = new Produto("a", 10, 2);
        estoque.cadastraProduto(a);
        Menu menu = new Menu(estoque);
        menu.controlaMenuEstoque();
    }
}