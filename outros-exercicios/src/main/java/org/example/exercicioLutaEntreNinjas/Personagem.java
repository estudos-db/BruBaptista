package org.example.exercicioLutaEntreNinjas;

import java.util.HashMap;
import java.util.Map;

public class Personagem {
    private String nome;
    private Map<String, Integer> jutsus;
    private int chakra = 100;
    private int vida = 100;

    public Personagem(String nome) {
        this.nome = nome;
        this.jutsus = new HashMap<>();
    }

    public String aprenderJutsu(String jutsu, int dano) {
        if(!jutsus.containsKey(jutsu)) {
            jutsus.put(jutsu, dano);
            StringBuilder sb = new StringBuilder();
            sb.append("O ninja ")
                    .append(this.nome)
                    .append(" aprendeu o jutsu: ")
                    .append(jutsu);
            return sb.toString();
        } else
            return "Não foi possível aprender esse jutsu";
    }

    public Map<String, Integer> getJutsus() {
        return jutsus;
    }
}