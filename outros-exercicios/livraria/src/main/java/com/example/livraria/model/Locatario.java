package com.example.livraria.model;

import com.example.livraria.model.enums.Sexo;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Entity
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
}