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
        this.setNome(nome);
        this.sexo = sexo;
        this.telefone = telefone.getTelefone();
        this.setEmail(email);
        this.setDataDeNascimento(dataDeNascimento);
        this.setcpf(cpf);
    }

    public Locatario(String nome, Telefone telefone, String email,
                     LocalDate dataDeNascimento, int cpf) {
        this.setNome(nome);
        this.telefone = telefone.getTelefone();
        this.setEmail(email);
        this.setDataDeNascimento(dataDeNascimento);
        this.setcpf(cpf);
    }

    public void setNome(String nome) {
        if(nome.isEmpty())
            throw new IllegalArgumentException("Nome inválido");
        this.nome = nome;
    }

    public void setEmail(String email) {
        if(!email.contains("@") || email.contains(" ")) {
            throw new IllegalArgumentException("Email inválido");
        }
        this.email = email;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        if(dataDeNascimento.getYear() < 1900)
            throw new IllegalArgumentException("Ano de nascimento inválido");

        this.dataDeNascimento = dataDeNascimento;
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

    public String getTelefone() {
        return this.telefone;
    }

    public String getEmail() {
        return this.email;
    }

    public LocalDate getDataDeNascimento() {
        return this.dataDeNascimento;
    }

    public int getCpf() {
        return this.cpf;
    }
}