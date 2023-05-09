package com.example.livraria.dto;

import com.example.livraria.model.Livro;
import com.example.livraria.model.Locatario;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

public class AluguelDto {
    private long id;
    @NotNull
    private Locatario locatario;
    @NotEmpty
    private List<Livro> livros;
    private LocalDate dataRetirada;
    private LocalDate dataDevolucao;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Locatario getLocatario() {
        return locatario;
    }

    public void setLocatario(Locatario locatario) {
        this.locatario = locatario;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    public LocalDate getDataRetirada() {
        return dataRetirada;
    }

    public void setDataRetirada(LocalDate dataRetirada) {
        this.dataRetirada = dataRetirada;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
}