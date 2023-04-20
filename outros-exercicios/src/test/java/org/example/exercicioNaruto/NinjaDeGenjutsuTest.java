package org.example.exercicioNaruto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NinjaDeGenjutsuTest {

    NinjaDeGenjutsu itachi = new NinjaDeGenjutsu("Itachi", 20, "Akatsuki", 10);
    @DisplayName("Deve retornar que o ninja atacou")
    @Test
    void deveRetornarNinjaAtacou() {
        assertEquals("O ninja Itachi está usando um jutsu de Genjutsu", itachi.usarJutsu());
    }

    @DisplayName("Deve retornar que o ninja desviou")
    @Test
    void deveRetornarNinjaDesviou() {
        assertEquals("O ninja Itachi está desviando de um ataque usando sua habilidade em Genjutsu",
                itachi.desviar());
    }
}