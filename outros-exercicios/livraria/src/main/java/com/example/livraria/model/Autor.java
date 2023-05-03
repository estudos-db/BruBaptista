package com.example.livraria.model;

import com.example.livraria.model.enums.Sexo;

import java.time.LocalDate;

public class Autor {
    private String nome;
    private Sexo sexo;
    private int anoDeNascimento;
    private int cpf;

    public Autor(String nome, Sexo sexo, int anoDeNascimento, int cpf) {
        this.nome = nome;
        this.sexo = sexo;
        this.anoDeNascimento = anoDeNascimento;
        this.cpf = cpf;
    }

    public Autor(String nome, int anoDeNascimento, int cpf) {
        this.nome = nome;
        this.anoDeNascimento = anoDeNascimento;
        this.cpf = cpf;
    }
}