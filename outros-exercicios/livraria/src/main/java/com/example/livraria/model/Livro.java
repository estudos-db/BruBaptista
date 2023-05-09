package com.example.livraria.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private int isbn;
    private LocalDate dataDePublicacao;
    private boolean alugado = false;
    @ManyToMany
    private List<Autor> autores = new ArrayList<>();
}