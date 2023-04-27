package org.example.exercicioLutaEntreNinjas;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PersonagemTest {

    Personagem hina = new Personagem("Hina");
    Jutsu rasengan = new Jutsu("rasengan", 10, 10);


    @DisplayName("Deve consumir vida do ninja")
    @Test
    void deveConsumirVida() {
        hina.consumirVida(50);

        assertEquals(50, hina.getVida());
    }

    @DisplayName("Deve consumir chakra do ninja")
    @Test
    void deveConsumirChakra() {
        hina.consumirChakra(50);

        assertEquals(50, hina.getChakra());
    }

    @DisplayName("Deve adicionar um novo jutsu")
    @Test
    void deveAdicionarJutsu() {
        assertEquals("O ninja Hina aprendeu o jutsu: rasengan",
                hina.aprenderJutsu("rasengan", rasengan));
        assertTrue(hina.getJutsus().containsKey("rasengan"));
    }

    @DisplayName("Não deve adicionar um jutsu repetido")
    @Test
    void naoDeveAdicionarJutsu() {
        hina.aprenderJutsu("rasengan", rasengan);

        assertEquals("Não foi possível aprender esse jutsu",
                hina.aprenderJutsu("rasengan", rasengan));
    }

    @DisplayName("Deve retornar os jutsus que o personagem sabe")
    @Test
    void deveRetornarJutsus() {
        hina.aprenderJutsu("rasengan", rasengan);
        Map<String, Jutsu> jutsusEsperados = new HashMap<>();
        jutsusEsperados.put("rasengan", rasengan);

        assertEquals(jutsusEsperados, hina.getJutsus());
    }

    @DisplayName("Deve retornar que o ninja atacou")
    @Test
    void deveRetornarNinjaAtacou() {
        assertEquals("O ninja Hina está atacando usando o rasengan", hina.usarJutsu(rasengan));
    }

    @DisplayName("Atacar deve consumir chakra")
    @Test
    void atacarDeveConsumirChakra() {
        hina.usarJutsu(rasengan);

        assertEquals(90, hina.getChakra());
    }

    @DisplayName("Deve retornar que o ninja está incapacitado senão tiver chakra pra atacar")
    @Test
    void deveRetornarNinjaIncapacitadoAtaque() {
        hina.consumirChakra(91);
        assertEquals("O ninja está incapacitado por falta de chakra", hina.usarJutsu(rasengan));
        assertEquals(0, hina.getChakra());
    }

    @DisplayName("Desviar deve consumir chakra")
    @Test
    void desviarDeveConsumirChakra() {
        hina.desviar();

        assertEquals(95, hina.getChakra());
    }

    //O teste a seguir deve falhar algumas vezes por depender do Math.random()
    @DisplayName("Deve retornar que o ninja desviou ou não")
    @Test
    void deveRetornarNinjaDesviou() {
        assertTrue(hina.desviar() || !hina.desviar());
    }

    @DisplayName("Um ninja com 5 ou menos de chakra não pode desviar")
    @Test
    void deveRetornarNinjaIncapazDeDesviar() {
        hina.consumirChakra(95);
        assertFalse(hina.desviar());
    }
}