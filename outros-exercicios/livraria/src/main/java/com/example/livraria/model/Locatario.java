package com.example.livraria.model;

import com.example.livraria.model.enums.Sexo;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"cpf", "email"})})
public class Locatario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private Sexo sexo;
    private String telefone;
    private String email;
    private LocalDate dataDeNascimento;
    private int cpf;
    @OneToMany
    private List<Aluguel> alugeis = new ArrayList<>();
}