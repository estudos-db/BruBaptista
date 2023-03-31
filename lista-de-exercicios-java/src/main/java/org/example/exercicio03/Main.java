package org.example.exercicio03;

public class Main {
    public static void main(String[] args) {
        Escolhas pedra = Escolhas.PEDRA;
        Escolhas papel = Escolhas.PAPEL;
        Escolhas tesoura = Escolhas.TESOURA;
        Jogador jogador = new Jogador(pedra);
        Maquina maquina = new Maquina();
        Jokenpo jokenpo = new Jokenpo(jogador, maquina);
        System.out.println(jokenpo.jogar());
    }
}
