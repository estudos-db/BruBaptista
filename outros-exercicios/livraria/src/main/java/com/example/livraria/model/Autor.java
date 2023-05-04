package com.example.livraria.model;

import com.example.livraria.model.enums.Sexo;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"cpf"})})
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private Sexo sexo;
    private int anoDeNascimento;
    private int cpf;
}