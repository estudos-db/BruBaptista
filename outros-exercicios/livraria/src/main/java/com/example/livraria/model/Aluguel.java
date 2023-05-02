package com.example.livraria.model;

import java.time.LocalDate;

public class Aluguel {
    private LocalDate dataRetirada;
    private LocalDate dataDevolucao;

    public Aluguel() {
        this.dataRetirada = LocalDate.now();
        this.dataDevolucao = this.dataRetirada.plusDays(2);
    }
}