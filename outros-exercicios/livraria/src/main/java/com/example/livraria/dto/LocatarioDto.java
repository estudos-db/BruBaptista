package com.example.livraria.dto;

import com.example.livraria.model.enums.Sexo;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;
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

    public void setTelefone(int ddd, int numero) {
        StringBuilder sb = new StringBuilder();
        sb.append("(")
                .append(ddd)
                .append(")")
                .append(numero);
        this.telefone = sb.toString();
    }

    public void setTelefone(String telefone) {
        String telefoneSemParenteses = telefone.replace("(", "")
                                                    .replace(")", "");
        int ddd = Integer.parseInt(telefoneSemParenteses.substring(0, 2));
        int numero = Integer.parseInt(telefoneSemParenteses.substring(2));
        setTelefone(ddd, numero);
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
}
