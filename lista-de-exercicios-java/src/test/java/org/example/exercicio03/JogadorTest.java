package org.example.exercicio03;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class JogadorTest {
    @DisplayName("A escolha do jogador deve ser pedra, papel ou tesoura")
    @Test
    void escolhaJogador() {
        Escolhas pedra = Escolhas.PEDRA;
        Escolhas papel = Escolhas.PAPEL;
        Escolhas tesoura = Escolhas.TESOURA;
        Jogador jogadorPedra = new Jogador(pedra);
        Jogador jogadorPapel = new Jogador(papel);
        Jogador jogadorTesoura = new Jogador(tesoura);

        assertEquals(Escolhas.PEDRA, jogadorPedra.getEscolha());
        assertEquals(Escolhas.PAPEL, jogadorPapel.getEscolha());
        assertEquals(Escolhas.TESOURA, jogadorTesoura.getEscolha());
    }
}