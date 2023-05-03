package com.example.livraria.model;

import java.time.LocalDate;

public class Livro {
    private String nome;
    private int isbn;
    private LocalDate dataDePublicacao;

    public Livro(String nome, int isbn, LocalDate dataDePublicacao) {
        this.nome = nome;
        this.isbn = isbn;
        this.dataDePublicacao = dataDePublicacao;
    }
}