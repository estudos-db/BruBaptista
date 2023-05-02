package com.example.livraria.model;

public class Telefone {
    private int ddd;
    private int numero;

    public Telefone(int ddd, int numero) {
        this.setDdd(ddd);
        this.setNumero(numero);
    }

    public void setDdd(int ddd) {
        if(ddd < 10 || ddd > 99)
            throw new IllegalArgumentException("O DDD deve ter 2 dígitos");
        this.ddd = ddd;
    }

    public void setNumero(int numero) {
        if(numero < 10000000 || numero > 999999999)
            throw new IllegalArgumentException("O número deve ter 8 ou 9 dígitos");
        this.numero = numero;
    }

    public int getDdd() {
        return this.ddd;
    }

    public int getNumero() {
        return this.numero;
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
