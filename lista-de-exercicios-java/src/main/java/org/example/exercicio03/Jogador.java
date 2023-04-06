package org.example.exercicio03;

public class Jogador implements JogadorBase {
    private Escolha escolha;

    public Jogador(Escolha escolha) {
        this.escolha = escolha;
    }

    @Override
    public Escolha getEscolha() {
        return escolha;
    }
}
