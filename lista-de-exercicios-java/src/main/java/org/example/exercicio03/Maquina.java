package org.example.exercicio03;

public class Maquina implements JogadorBase {
    private Escolha escolha;

    @Override
    public Escolha getEscolha() {
        int aleatoria = (int) Math.floor(Math.random() * 3);
        this.escolha = Escolha.values()[aleatoria];
        return escolha;
    }
}
