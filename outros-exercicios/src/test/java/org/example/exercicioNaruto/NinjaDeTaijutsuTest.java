package org.example.exercicioNaruto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NinjaDeTaijutsuTest {

    NinjaDeTaijutsu lee = new NinjaDeTaijutsu("Lee", 18, "Folha", 10);
    @DisplayName("O chakra de um ninja de Taijutsu deve ser sempre zero")
    @Test
    void chakraDeveSerSempreZero() {
        assertEquals(0, lee.getChakra());
        assertEquals("Um ninja de Taijutsu não pode aumentar seu chakra",lee.aumentarChakra(-1));
        assertEquals("Um ninja de Taijutsu não pode aumentar seu chakra",lee.aumentarChakra(0));
        assertEquals("Um ninja de Taijutsu não pode aumentar seu chakra",lee.aumentarChakra(1));
    }

    @DisplayName("Deve retornar erro ao tentar criar um ninja de Taijutsu com energia menor que 0 ou maior que 10")
    @Test
    void deveRetornarErroPersonagemComEnergiaMenorQueZeroOuMaiorQueDez() {
        assertThrows(IllegalArgumentException.class, () -> {
            Personagem personagemZero = new Personagem("zero", 10, "Folha", -1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Personagem personagemDez = new Personagem("dez", 10, "Folha", 11);
        });
    }

    @DisplayName("Deve retornar que o ninja atacou")
    @Test
    void deveRetornarNinjaAtacou() {
        assertEquals("O ninja Lee está usando um golpe de Taijutsu", lee.usarJutsu());
    }

    @DisplayName("Deve retornar que o ninja desviou")
    @Test
    void deveRetornarNinjaDesviou() {
        assertEquals("O ninja Lee está desviando de um ataque usando sua habilidade em Taijutsu",
                lee.desviar());
    }
}