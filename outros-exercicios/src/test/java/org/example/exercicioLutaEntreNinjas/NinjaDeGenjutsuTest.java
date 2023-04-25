package org.example.exercicioLutaEntreNinjas;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NinjaDeGenjutsuTest {

    NinjaDeGenjutsu itachi = new NinjaDeGenjutsu("Itachi");
    Jutsu rasengan = new Jutsu("rasengan", 10, 10);
    @DisplayName("Deve retornar que o ninja atacou")
    @Test
    void deveRetornarNinjaAtacou() {
        assertEquals("O ninja Itachi está atacando usando o rasengan", itachi.usarJutsu(rasengan));
    }

    @DisplayName("Atacar deve consumir chakra")
    @Test
    void atacarDeveConsumirChakra() {
        itachi.usarJutsu(rasengan);

        assertEquals(90, itachi.getChakra());
    }

    @DisplayName("Deve retornar que o ninja está incapacitado senão tiver chakra pra atacar")
    @Test
    void deveRetornarNinjaIncapacitadoAtaque() {
        itachi.setChakra(10);
        assertEquals("O ninja está incapacitado por falta de chakra", itachi.usarJutsu(rasengan));
    }

    @DisplayName("Deve retornar que o ninja desviou")
    @Test
    void deveRetornarNinjaDesviou() {
        assertEquals("O ninja Itachi está desviando de um ataque usando sua habilidade em Genjutsu",
                itachi.desviar());
    }

    @DisplayName("Desviar deve consumir chakra")
    @Test
    void desviarDeveConsumirChakra() {
        itachi.desviar();

        assertEquals(95, itachi.getChakra());
    }

    @DisplayName("Deve retornar que o ninja está incapacitado senão tiver chakra pra desviar")
    @Test
    void deveRetornarNinjaIncapacitadoDesvio() {
        itachi.setChakra(5);
        assertEquals("O ninja está incapacitado por falta de chakra", itachi.desviar());
    }
}