package org.example.exercicioLutaEntreNinjas;

import java.util.HashMap;
import java.util.Map;

public class Personagem {
    private String nome;
    private Map<String, Jutsu> jutsus;
    private int chakra = 100;
    private int vida = 100;

    public Personagem(String nome) {
        this.nome = nome;
        this.jutsus = new HashMap<>();
    }

    public String aprenderJutsu(String nomeDoJutsu, Jutsu jutsu) {
        if(!jutsus.containsKey(nomeDoJutsu)) {
            jutsus.put(nomeDoJutsu, jutsu);
            StringBuilder sb = new StringBuilder();
            sb.append("O ninja ")
                    .append(this.nome)
                    .append(" aprendeu o jutsu: ")
                    .append(nomeDoJutsu);
            return sb.toString();
        } else
            return "Não foi possível aprender esse jutsu";
    }

    public boolean temJutsu(String nomeJutsu) {
        return jutsus.containsKey(nomeJutsu);
    }

    public Map<String, Jutsu> getJutsus() {
        return jutsus;
    }

    public String getNome() {
        return nome;
    }

    public int getChakra() {
        return chakra;
    }

    private void setChakra(int chakra) {
        this.chakra = chakra;
    }

    public int getVida() {
        return vida;
    }

    private void setVida(int vida) {
        this.vida = vida;
    }

    public void consumirVida(int consumo) {
        int vidaAtual = this.getVida() - consumo;
        this.setVida(vidaAtual);
    }

    public void consumirChakra(int consumo) {
        int chackraAtual = this.getChakra() - consumo;
        this.setChakra(chackraAtual);
    }

    public String usarJutsu(Jutsu jutsu) {
        if(this.getChakra() < jutsu.getConsumoDeChakra()) {
            this.setChakra(0);
            return "O ninja está incapacitado por falta de chakra";
        }

        consumirChakra(jutsu.getConsumoDeChakra());
        StringBuilder sb = new StringBuilder();
        sb.append("O ninja ")
                .append(this.getNome())
                .append(" está atacando usando o ")
                .append(jutsu.getNome());
        return sb.toString();
    }

    public boolean desviar() {
        if(this.getChakra() <= 5) {
            System.out.println("O ninja não pode desviar por falta de chakra");
            return false;
        }

        consumirChakra(5);
        double conseguirDesviar = Math.floor(Math.random() * 2);
        return conseguirDesviar == 1;
    }
}