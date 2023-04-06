package org.example.exercicio03;

public class Jogador implements JogadorBase {
    private Escolhas escolha;

    public Jogador(Escolhas escolha) {
        this.escolha = escolha;
    }

    @Override
    public Escolhas getEscolha() {
        return escolha;
    }
}
