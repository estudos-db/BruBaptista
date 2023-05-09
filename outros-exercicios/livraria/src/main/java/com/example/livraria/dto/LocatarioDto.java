package com.example.livraria.dto;

import com.example.livraria.model.Aluguel;
import com.example.livraria.model.enums.Sexo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class LocatarioDto {
    private long id;
    @NotBlank
    private String nome;
    private Sexo sexo;
    @NotBlank
    private String telefone;
    @NotBlank
    private String email;
    @NotNull
    private LocalDate dataDeNascimento;
    @NotNull
    private int cpf;
    private List<Aluguel> alugeis = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public List<Aluguel> getAlugeis() {
        return alugeis;
    }

    public void setAlugeis(List<Aluguel> alugeis) {
        this.alugeis = alugeis;
    }
}
