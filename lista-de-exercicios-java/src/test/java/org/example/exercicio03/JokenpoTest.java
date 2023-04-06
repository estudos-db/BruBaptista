package org.example.exercicio03;

import static org.example.exercicio03.Escolha.PEDRA;
import static org.example.exercicio03.Escolha.PAPEL;
import static org.example.exercicio03.Escolha.TESOURA;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class JokenpoTest {
    Jogador jogadorPedra = new Jogador(PEDRA);
    Jogador jogadorPapel = new Jogador(PAPEL);
    Jogador jogadorTesoura = new Jogador(TESOURA);

    @DisplayName("A escolha pedra deve ganhar de tesoura")
    @Test
    void pedraGanhaTesoura() {
        Jokenpo jokenpo1 = new Jokenpo(jogadorPedra, jogadorTesoura);
        Jokenpo jokenpo2 = new Jokenpo(jogadorTesoura, jogadorPedra);

        assertTrue(jokenpo1.jogar().equals("Vencedor: Player 1 com PEDRA"));
        assertTrue(jokenpo2.jogar().equals("Vencedor: Player 2 com PEDRA"));
    }

    @DisplayName("A escolha papel deve ganhar de pedra")
    @Test
    void papelGanhaPedra() {
        Jokenpo jokenpo1 = new Jokenpo(jogadorPapel, jogadorPedra);
        Jokenpo jokenpo2 = new Jokenpo(jogadorPedra, jogadorPapel);

        assertTrue(jokenpo1.jogar().equals("Vencedor: Player 1 com PAPEL"));
        assertTrue(jokenpo2.jogar().equals("Vencedor: Player 2 com PAPEL"));
    }

    @DisplayName("A escolha tesoura deve ganhar de papel")
    @Test
    void tesouraGanhaPapel() {
        Jokenpo jokenpo1 = new Jokenpo(jogadorTesoura, jogadorPapel);
        Jokenpo jokenpo2 = new Jokenpo(jogadorPapel, jogadorTesoura);

        assertTrue(jokenpo1.jogar().equals("Vencedor: Player 1 com TESOURA"));
        assertTrue(jokenpo2.jogar().equals("Vencedor: Player 2 com TESOURA"));
    }
}