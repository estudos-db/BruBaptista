package org.example.exercicioLutaEntreNinjas;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PersonagemTest {

    Personagem hina = new Personagem("Hina");
    Jutsu rasengan = new Jutsu("rasengan", 10, 10);
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
}