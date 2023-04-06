package org.example.exercicio03;

import static org.example.exercicio03.Escolhas.PEDRA;
import static org.example.exercicio03.Escolhas.PAPEL;
import static org.example.exercicio03.Escolhas.TESOURA;

public class Jokenpo {
    private JogadorBase jogador1;
    private JogadorBase jogador2;

    public Jokenpo(JogadorBase jogador1, JogadorBase jogador2) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
    }

    public String jogar() {
        Escolhas jogada1 = this.jogador1.getEscolha();
        Escolhas jogada2 = this.jogador2.getEscolha();

        if(jogada1 == jogada2)
            return "Empate";
        else if(jogada1 == PAPEL && jogada2 == PEDRA)
            return "Vencedor: Player 1 com " + jogada1.toString();
        else if(jogada1 == TESOURA && jogada2 == PAPEL)
            return "Vencedor: Player 1 com " + jogada1.toString();
        else if(jogada1 == PEDRA && jogada2 == TESOURA)
            return "Vencedor: Player 1 com " + jogada1.toString();
        return "Vencedor: Player 2 com " + jogada2.toString();
    }
}
