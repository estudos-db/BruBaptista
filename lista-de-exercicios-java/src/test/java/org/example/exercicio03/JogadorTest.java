package org.example.exercicio03;

import static org.example.exercicio03.Escolha.PEDRA;
import static org.example.exercicio03.Escolha.PAPEL;
import static org.example.exercicio03.Escolha.TESOURA;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class JogadorTest {
    @DisplayName("A escolha do jogador deve ser pedra, papel ou tesoura")
    @Test
    void escolhaJogador() {
        Jogador jogadorPedra = new Jogador(PEDRA);
        Jogador jogadorPapel = new Jogador(PAPEL);
        Jogador jogadorTesoura = new Jogador(TESOURA);

        assertEquals(PEDRA, jogadorPedra.getEscolha());
        assertEquals(PAPEL, jogadorPapel.getEscolha());
        assertEquals(TESOURA, jogadorTesoura.getEscolha());
    }
}