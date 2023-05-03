package com.example.livraria.model;

public class Telefone {
    private int ddd;
    private int numero;

    public Telefone(int ddd, int numero) {
        this.ddd = ddd;
        this.numero = numero;
    }

    public String getTelefone() {
        StringBuilder sb = new StringBuilder();
        sb.append("(")
                .append(this.ddd)
                .append(")")
                .append(this.numero);
        return sb.toString();
    }
}
