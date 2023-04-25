package org.example.exercicioLutaEntreNinjas;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NinjaDeNinjutsuTest {

    NinjaDeNinjutsu kakashi = new NinjaDeNinjutsu("Kakashi");
    Jutsu rasengan = new Jutsu("rasengan", 10, 10);
    @DisplayName("Deve retornar que o ninja atacou")
    @Test
    void deveRetornarNinjaAtacou() {
        assertEquals("O ninja Kakashi está atacando usando o rasengan", kakashi.usarJutsu(rasengan));
    }

    @DisplayName("Atacar deve consumir chakra")
    @Test
    void atacarDeveConsumirChakra() {
        kakashi.usarJutsu(rasengan);

        assertEquals(90, kakashi.getChakra());
    }

    @DisplayName("Deve retornar que o ninja está incapacitado senão tiver chakra pra atacar")
    @Test
    void deveRetornarNinjaIncapacitadoAtaque() {
        kakashi.setChakra(10);
        assertEquals("O ninja está incapacitado por falta de chakra", kakashi.usarJutsu(rasengan));
    }

    @DisplayName("Deve retornar que o ninja desviou")
    @Test
    void deveRetornarNinjaDesviou() {
        assertEquals("O ninja Kakashi está desviando de um ataque usando sua habilidade em Ninjutsu",
                kakashi.desviar());
    }

    @DisplayName("Desviar deve consumir chakra")
    @Test
    void desviarDeveConsumirChakra() {
        kakashi.desviar();

        assertEquals(95, kakashi.getChakra());
    }

    @DisplayName("Deve retornar que o ninja está incapacitado senão tiver chakra pra desviar")
    @Test
    void deveRetornarNinjaIncapacitadoDesvio() {
        kakashi.setChakra(5);
        assertEquals("O ninja está incapacitado por falta de chakra", kakashi.desviar());
    }
}