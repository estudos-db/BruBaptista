package org.example.exercicioLutaEntreNinjas;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LutaTest {

        NinjaDeGenjutsu ninja1 = new NinjaDeGenjutsu("ninja 1");
        NinjaDeNinjutsu ninja2 = new NinjaDeNinjutsu("ninja 2");
        Jutsu bolaDeFogo = new Jutsu("Bola de fogo", 10, 5);

    @DisplayName("Deve retornar de forma aleatória o ninja que deve começar atacando")
    @Test
    void deveRetornarNinjaAtacante() {
        ninja1.aprenderJutsu("Bola de fogo", bolaDeFogo);
        Luta luta = new Luta(ninja1, ninja2);

        luta.ordenarNinjas();
        assertTrue(luta.getNinjaInicial() == ninja1 || luta.getNinjaInicial() == ninja2);
    }

    @DisplayName("Deve retornar mensagem de jutsu inválido")
    @Test
    void deveRetornarJutsuInvalido() {
        ninja1.aprenderJutsu("Bola de fogo", bolaDeFogo);
        Luta luta = new Luta(ninja1, ninja2);
        Jutsu invalido = new Jutsu("Jutsu inválido", 10, 5);

        assertEquals("O ninja ninja 1 não possui o jutsu Jutsu inválido",
                luta.batalha(ninja1, invalido, ninja2, false));
    }

    @DisplayName("Deve retornar mensagem do ninja defensor tentando desviar")
    @Test
    void deveRetornarDesvio() {
        ninja1.aprenderJutsu("Bola de fogo", bolaDeFogo);
        Luta luta = new Luta(ninja1, ninja2);

        String resultado = luta.batalha(ninja1, bolaDeFogo, ninja2, true);
        assertTrue(resultado.contains("O ninja ninja 2 desviou") ||
                resultado.contains("O ninja ninja 2 não conseguiu desviar"));
    }

    @DisplayName("Deve retornar mensagem de dano causado")
    @Test
    void deveRetornarDano() {
        ninja1.aprenderJutsu("Bola de fogo", bolaDeFogo);
        Luta luta = new Luta(ninja1, ninja2);

        String resultado = luta.batalha(ninja1, bolaDeFogo, ninja2, false);
        assertTrue(resultado.contains("O ninja ninja 2 levou 10 de dano"));
    }

    @DisplayName("Deve retornar mensagem de jutsu não encontrado")
    @Test
    void deveRetornarMensagemDeJutsuNaoEncontrado() {
        ninja1.aprenderJutsu("Bola de fogo", bolaDeFogo);
        Luta luta = new Luta(ninja1, ninja2);
        Jutsu chidori = new Jutsu("Chidori", 10, 10);

        String resultado = luta.batalha(ninja1, chidori, ninja2, false);
        String mensagemEsperada = "O ninja ninja 1 não possui o jutsu Chidori";
        assertEquals(mensagemEsperada, resultado);
    }

    @DisplayName("Deve causar dano quando o defensor não desvia")
    @Test
    void deveCausarDanoQuandoDefensorNaoDesvia() {
        ninja1.aprenderJutsu("Bola de fogo", bolaDeFogo);
        ninja2.aprenderJutsu("Bola de fogo", bolaDeFogo);
        Luta luta = new Luta(ninja1, ninja2);

        String resultado = luta.batalha(ninja1, bolaDeFogo, ninja2, false);
        String mensagemEsperada = "O ninja ninja 1 usou Bola de fogo\n" +
                "O ninja ninja 2 levou 10 de dano";
        assertEquals(mensagemEsperada, resultado);
    }

    @DisplayName("Deve retornar mensagem de fim de luta quando a vida de um ninja chega em zero")
    @Test
    void deveRetornarMensagemDeFimDaLutaQuandoDefensorMorre() {
        ninja1.aprenderJutsu("Bola de fogo", bolaDeFogo);
        ninja2.aprenderJutsu("Bola de fogo", bolaDeFogo);
        Luta luta = new Luta(ninja1, ninja2);

        ninja2.setVida(10);
        String resultado = luta.batalha(ninja1, bolaDeFogo, ninja2, false);
        String mensagemEsperada = "O ninja ninja 1 usou Bola de fogo\n" +
                "O ninja ninja 2 levou 10 de dano\n" +
                "O ninja ninja 2 não tem mais vida e não pode mais lutar";
        assertEquals(mensagemEsperada, resultado);
    }

    @DisplayName("Deve retornar mensagem de fim de luta quando o chakra de um ninja chega em zero")
    @Test
    void deveRetornarMensagemDeFimDaLutaQuandoAtacanteMorre() {
        ninja1.aprenderJutsu("Bola de fogo", bolaDeFogo);
        ninja2.aprenderJutsu("Bola de fogo", bolaDeFogo);
        Luta luta = new Luta(ninja1, ninja2);

        ninja1.setChakra(5);
        String resultado = luta.batalha(ninja1, bolaDeFogo, ninja2, false);
        String mensagemEsperada = "O ninja ninja 1 usou Bola de fogo\n" +
                "O ninja ninja 2 levou 10 de dano\n" +
                "O ninja ninja 1 não tem mais chakra e não pode mais lutar";
        assertEquals(mensagemEsperada, resultado);
    }

    @DisplayName("Deve retornar empate")
    @Test
    void deveRetornarMensagemDeFimDaLutaQuandoAtacanteEDefensorMorrem() {
        ninja1.aprenderJutsu("Bola de fogo", bolaDeFogo);
        ninja2.aprenderJutsu("Bola de fogo", bolaDeFogo);
        Luta luta = new Luta(ninja1, ninja2);

        ninja1.setChakra(5);
        ninja2.setVida(10);
        String resultado = luta.batalha(ninja1, bolaDeFogo, ninja2, false);
        String mensagemEsperada = "O ninja ninja 1 usou Bola de fogo\n" +
                "O ninja ninja 2 levou 10 de dano\n" +
                "O ninja ninja 1 não tem mais chakra e não pode mais lutar\n" +
                "O ninja ninja 2 não tem mais vida e não pode mais lutar";
        assertEquals(mensagemEsperada, resultado);
    }
}