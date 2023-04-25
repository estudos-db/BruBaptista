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

    public Map<String, Jutsu> getJutsus() {
        return jutsus;
    }
}