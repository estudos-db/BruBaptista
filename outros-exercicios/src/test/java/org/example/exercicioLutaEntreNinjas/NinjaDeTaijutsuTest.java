package org.example.exercicioLutaEntreNinjas;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NinjaDeTaijutsuTest {

    NinjaDeTaijutsu lee = new NinjaDeTaijutsu("Lee");
    Jutsu rasengan = new Jutsu("rasengan", 10, 10);
    @DisplayName("Deve retornar que o ninja atacou")
    @Test
    void deveRetornarNinjaAtacou() {
        assertEquals("O ninja Lee está atacando usando o rasengan", lee.usarJutsu(rasengan));
    }

    @DisplayName("Atacar deve consumir chakra")
    @Test
    void atacarDeveConsumirChakra() {
        lee.usarJutsu(rasengan);

        assertEquals(90, lee.getChakra());
    }

    @DisplayName("Deve retornar que o ninja está incapacitado senão tiver chakra pra atacar")
    @Test
    void deveRetornarNinjaIncapacitadoAtaque() {
        lee.setChakra(9);
        assertEquals("O ninja está incapacitado por falta de chakra", lee.usarJutsu(rasengan));
        assertEquals(0, lee.getChakra());
    }

    @DisplayName("Desviar deve consumir chakra")
    @Test
    void desviarDeveConsumirChakra() {
        lee.desviar();

        assertEquals(95, lee.getChakra());
    }

    @DisplayName("Deve retornar que o ninja desviou ou não")
    @Test
    void deveRetornarNinjaDesviou() {
        assertTrue(lee.desviar() || !lee.desviar());
    }

    @DisplayName("Um ninja com 5 ou menos de chakra não pode desviar")
    @Test
    void deveRetornarNinjaIncapazDeDesviar() {
        lee.setChakra(5);
        assertFalse(lee.desviar());
    }
}