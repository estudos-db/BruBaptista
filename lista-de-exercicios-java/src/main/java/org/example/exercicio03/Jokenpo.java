package org.example.exercicio03;

public class Jokenpo {
    private JogadorBase jogador1;
    private JogadorBase jogador2;

    public Jokenpo(JogadorBase jogador1, JogadorBase jogador2) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
    }

    public String jogar() {
        Escolhas jogador1 = this.jogador1.getEscolha();
        Escolhas jogador2 = this.jogador2.getEscolha();
        Escolhas pedra = Escolhas.PEDRA;
        Escolhas papel = Escolhas.PAPEL;
        Escolhas tesoura = Escolhas.TESOURA;

        if(jogador1 == jogador2)
            return "Empate";
        else if(jogador1 == papel && jogador2 == pedra)
            return "Vencedor: Player 1 com " + jogador1.toString();
        else if(jogador1 == tesoura && jogador2 == papel)
            return "Vencedor: Player 1 com " + jogador1.toString();
        else if(jogador1 == pedra && jogador2 == tesoura)
            return "Vencedor: Player 1 com " + jogador1.toString();
        return "Vencedor: Player 2 com " + jogador2.toString();
    }
}
