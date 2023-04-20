package org.example.exercicioNaruto;

import java.util.Arrays;

public class Personagem {
    private String nome;
    private int idade;
    private String aldeia;
    private int chakra;
    private String[] jutsus;

    public Personagem(String nome, int idade, String aldeia, int chakra) {
        this.nome = nome;
        this.idade = idade;
        this.aldeia = aldeia;
        this.setChakra(chakra);
        this.jutsus = new String[1];
    }

    public String aprenderJutsu(String jutsu) {
        if(this.jutsus[0] == null) {
            this.jutsus[0] = jutsu;
            StringBuilder sb = new StringBuilder();
            sb.append("O ninja ")
                    .append(this.nome)
                    .append(" aprendeu o jutsu: ")
                    .append(this.jutsus[0]);
            return sb.toString();
        } else
            return "Um ninja iniciante não pode aprender mais de um jutsu";
    }

    public String aumentarChakra(int valor) {
        if(valor > 5)
            return "Um ninja não pode evoluir tanto assim de uma vez";
        if(valor <= 0)
            return "O aumento do chakra não pode ser nulo ou negativo";
        this.chakra += valor;
        StringBuilder sb = new StringBuilder();
        sb.append("O total de chakra do ninja ")
                .append(this.nome)
                .append(" agora é ")
                .append(this.chakra);
        return sb.toString();
    }

    private void setChakra(int chakra) {
        if(chakra >= 0 && chakra <= 10)
            this.chakra = chakra;
        else
            throw new IllegalArgumentException("Um ninja iniciante não pode ter essa quantidade de chakra");
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Personagem:\n")
                .append("Nome: ")
                .append(this.nome)
                .append("\nIdade: ")
                .append(this.idade)
                .append("\nAldeia: ")
                .append(this.aldeia)
                .append("\nChakra total: ")
                .append(this.chakra)
                .append("\nLista de jutsus: ")
                .append(Arrays.toString(this.jutsus));
        return sb.toString();
    }
    public String[] getJutsus() {
        return jutsus;
    }

    public int getChakra() {
        return chakra;
    }

    public String getNome() {
        return nome;
    }
}
