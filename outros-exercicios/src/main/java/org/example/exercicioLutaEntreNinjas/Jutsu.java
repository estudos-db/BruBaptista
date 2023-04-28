package org.example.exercicioLutaEntreNinjas;

public class Jutsu {
    private String nome;
    private int dano;
    private int consumoDeChakra;

    public Jutsu(String nome, int dano, int consumoDeChakra) {
        this.nome = nome;
        this.setDano(dano);
        this.setConsumoDeChakra(consumoDeChakra);
    }

    public void setDano(int dano) {
        if(dano >= 0 && dano <= 10)
            this.dano = dano;
        else
            throw new IllegalArgumentException("Dano inválido");
    }

    public void setConsumoDeChakra(int consumoDeChakra) {
        if(consumoDeChakra >= 0 && consumoDeChakra <= 10)
            this.consumoDeChakra = consumoDeChakra;
        else throw new IllegalArgumentException("Quantidade inválida");
    }

    public String getNome() {
        return nome;
    }

    public int getDano() {
        return dano;
    }

    public int getConsumoDeChakra() {
        return consumoDeChakra;
    }
}
