package com.example.livraria.model;

import com.example.livraria.model.enums.Sexo;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private Sexo sexo;
    private int anoDeNascimento;
    private int cpf;
}