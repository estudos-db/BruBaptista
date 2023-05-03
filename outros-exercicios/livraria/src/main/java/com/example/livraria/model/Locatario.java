package com.example.livraria.model;

import com.example.livraria.model.enums.Sexo;

import java.time.LocalDate;

public class Locatario {
    private String nome;
    private Sexo sexo;
    private String telefone;
    private String email;
    private LocalDate dataDeNascimento;
    private int cpf;

    public Locatario(String nome, Sexo sexo, Telefone telefone,
                     String email, LocalDate dataDeNascimento, int cpf) {
        this.nome = nome;
        this.sexo = sexo;
        this.telefone = telefone.getTelefone();
        this.email = email;
        this.dataDeNascimento = dataDeNascimento;
        this.cpf = cpf;
    }

    public Locatario(String nome, Telefone telefone, String email,
                     LocalDate dataDeNascimento, int cpf) {
        this.nome = nome;
        this.telefone = telefone.getTelefone();
        this.email = email;
        this.dataDeNascimento = dataDeNascimento;
        this.cpf = cpf;
    }
}