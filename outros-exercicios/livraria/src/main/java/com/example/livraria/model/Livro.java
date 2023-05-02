package com.example.livraria.model;

import java.time.LocalDate;

public class Livro {
    private String nome;
    private int isbn;
    private LocalDate dataDePublicacao;

    public Livro(String nome, int isbn, LocalDate dataDePublicacao) {
        this.setNome(nome);
        this.setisbn(isbn);
        this.dataDePublicacao = dataDePublicacao;
    }

    public void setNome(String nome) {
        if(nome.isEmpty())
            throw new IllegalArgumentException("Nome inválido");

        this.nome = nome;
    }

    public void setisbn(int isbn) {
        if(0 >= isbn)
            throw new IllegalArgumentException("isbn inválido");

        this.isbn = isbn;
    }

    public String getNome() {
        return nome;
    }

    public int getIsbn() {
        return isbn;
    }

    public LocalDate getDataDePublicacao() {
        return dataDePublicacao;
    }
}