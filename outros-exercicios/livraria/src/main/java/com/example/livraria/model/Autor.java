package com.example.livraria.model;

import com.example.livraria.model.enums.Sexo;

import java.time.LocalDate;

public class Autor {
    private String nome;
    private Sexo sexo;
    private int anoDeNascimento;
    private int cpf;

    public Autor(String nome, Sexo sexo, int anoDeNascimento, int cpf) {
        this.setNome(nome);
        this.sexo = sexo;
        this.setAnoDeNascimento(anoDeNascimento);
        this.setcpf(cpf);
    }

    public Autor(String nome, int anoDeNascimento, int cpf) {
        this.setNome(nome);
        this.setAnoDeNascimento(anoDeNascimento);
        this.setcpf(cpf);
    }

    public void setNome(String nome) {
        if(nome.isEmpty())
            throw new IllegalArgumentException("Nome inválido");

        this.nome = nome;
    }

    public void setAnoDeNascimento(int anoDeNascimento) {
        LocalDate dataAtual = LocalDate.now();
        if(anoDeNascimento > dataAtual.getYear())
            throw new IllegalArgumentException("Ano de nascimento inválido");

        this.anoDeNascimento = anoDeNascimento;
    }

    public void setcpf(int cpf) {
        if(0 >= cpf)
            throw new IllegalArgumentException("cpf inválido");

        this.cpf = cpf;
    }

    public String getNome() {
        return this.nome;
    }

    public Sexo getSexo() {
        return this.sexo;
    }

    public int getAnoDeNascimento() {
        return this.anoDeNascimento;
    }

    public int getCpf() {
        return this.cpf;
    }
}