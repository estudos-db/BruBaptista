package org.example.exercicio03;

import static org.example.exercicio03.Escolha.PEDRA;
import static org.example.exercicio03.Escolha.PAPEL;
import static org.example.exercicio03.Escolha.TESOURA;

public class Jokenpo {
    private JogadorBase jogador1;
    private JogadorBase jogador2;

    public Jokenpo(JogadorBase jogador1, JogadorBase jogador2) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
    }

    public String jogar() {
        Escolha jogada1 = this.jogador1.getEscolha();
        Escolha jogada2 = this.jogador2.getEscolha();
        return validarVencedor(jogada1, jogada2);
    }

    private String validarVencedor(Escolha jogada1, Escolha jogada2) {
        if(jogada1 == jogada2)
            return "Empate";
        else if(jogada1 == PAPEL && jogada2 == PEDRA ||
                jogada1 == TESOURA && jogada2 == PAPEL ||
                jogada1 == PEDRA && jogada2 == TESOURA)
            return "Vencedor: Player 1 com " + jogada1;
        return "Vencedor: Player 2 com " + jogada2.toString();
    }
}
