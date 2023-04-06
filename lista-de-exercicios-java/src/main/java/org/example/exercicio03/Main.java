package org.example.exercicio03;

import static org.example.exercicio03.Escolhas.PEDRA;
import static org.example.exercicio03.Escolhas.PAPEL;
import static org.example.exercicio03.Escolhas.TESOURA;

public class Main {
    public static void main(String[] args) {
        Jogador jogador = new Jogador(PEDRA);
        Maquina maquina = new Maquina();
        Jokenpo jokenpo = new Jokenpo(jogador, maquina);
        System.out.println(jokenpo.jogar());
    }
}
