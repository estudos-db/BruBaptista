package org.example.exercicio20;

public class Main {
    public static void main(String[] args) {
        Estoque estoque = new Estoque();
        estoque.inicializaEstoque();
        Produto a = new Produto("a", 10, 1);
        estoque.cadastraProduto(a);
        Menu menu = new Menu(estoque);

        menu.controlaMenu();
    }
}