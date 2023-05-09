package com.example.livraria.dto;

import com.example.livraria.model.Autor;

import java.time.LocalDate;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class LivroDto {
    private long id;
    @NotBlank
    private String nome;
    @NotNull
    private Integer isbn;
    @NotNull
    private LocalDate dataDePublicacao;
    private boolean alugado;
    @NotEmpty
    private List<Autor> autores;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIsbn() {
        return isbn;
    }

    public void setIsbn(Integer isbn) {
        this.isbn = isbn;
    }

    public boolean isAlugado() {
        return alugado;
    }

    public void setAlugado(boolean alugado) {
        this.alugado = alugado;
    }

    public LocalDate getDataDePublicacao() {
        return dataDePublicacao;
    }

    public void setDataDePublicacao(LocalDate dataDePublicacao) {
        this.dataDePublicacao = dataDePublicacao;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }
}
