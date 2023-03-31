package org.example.exercicio03;

public class Maquina implements JogadorBase {
    private Escolhas escolha;

    @Override
    public Escolhas getEscolha() {
        int aleatoria = (int) Math.floor(Math.random() * 3);
        this.escolha = Escolhas.values()[aleatoria];
        return escolha;
    }
}
