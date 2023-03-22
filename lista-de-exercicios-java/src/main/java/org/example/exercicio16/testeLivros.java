package org.example.exercicio16;

public class testeLivros {
    public static void main(String[] args) {
        Pessoa rafflesia = new Pessoa("rafflesia");
        Livro moon = new Livro("Book of Moon", "Nepenthes");
        rafflesia.pegarEmprestado(moon);
        rafflesia.pegarEmprestado(moon);
        rafflesia.devolverLivro(moon);
        rafflesia.devolverLivro(moon);
    }
}
