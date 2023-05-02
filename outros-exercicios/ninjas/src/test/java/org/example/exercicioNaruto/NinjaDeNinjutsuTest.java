package org.example.exercicioNaruto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NinjaDeNinjutsuTest {

    NinjaDeNinjutsu kakashi = new NinjaDeNinjutsu("Kakashi", 30, "Folha", 10);
    @DisplayName("Deve retornar que o ninja atacou")
    @Test
    void deveRetornarNinjaAtacou() {
        assertEquals("O ninja Kakashi está usando um jutsu de Ninjutsu", kakashi.usarJutsu());
    }

    @DisplayName("Deve retornar que o ninja desviou")
    @Test
    void deveRetornarNinjaDesviou() {
        assertEquals("O ninja Kakashi está desviando de um ataque usando sua habilidade em Ninjutsu",
                kakashi.desviar());
    }
}