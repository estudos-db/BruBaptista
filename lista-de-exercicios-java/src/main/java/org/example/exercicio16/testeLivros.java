package org.example.exercicio16;

public class testeLivros {
    public static void main(String[] args) {
        Livro moon = new Livro("Book of Moon", "Nepenthes");
        Livro eclipse = new Livro("Book of Eclipse", "Nepenthes");
        Biblioteca biblioteca = new Biblioteca();
        
        biblioteca.adicionarLivro(moon, true);
        biblioteca.adicionarLivro(eclipse, false);
        System.out.println();

        biblioteca.verificarDisponibilidade(eclipse);
        biblioteca.verificarDisponibilidade(moon);
        System.out.println();

        Pessoa rafflesia = new Pessoa("rafflesia");
        biblioteca.cadastrarUsuario(rafflesia, "rafflesia");
        biblioteca.buscarUsuario(rafflesia);
        System.out.println();


    }
}
