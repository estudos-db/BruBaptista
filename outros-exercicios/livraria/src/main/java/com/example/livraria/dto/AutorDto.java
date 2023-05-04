package com.example.livraria.dto;

import com.example.livraria.model.enums.Sexo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AutorDto {
    private Long id;
    @NotBlank
    private String nome;
    private Sexo sexo;
    @NotNull
    private Integer anoDeNascimento;
    @NotNull
    private Integer cpf;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getAnoDeNascimento() {
        return anoDeNascimento;
    }

    public void setAnoDeNascimento(Integer anoDeNascimento) {
        this.anoDeNascimento = anoDeNascimento;
    }

    public Integer getCpf() {
        return cpf;
    }

    public void setCpf(Integer cpf) {
        this.cpf = cpf;
    }
}
