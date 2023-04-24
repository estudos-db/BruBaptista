package org.example.exercicioLutaEntreNinjas;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PersonagemTest {

    Personagem hina = new Personagem("Hina");
    @DisplayName("Deve adicionar um novo jutsu")
    @Test
    void deveAdicionarJutsu() {
        assertEquals("O ninja Hina aprendeu o jutsu: rasengan",
                hina.aprenderJutsu("rasengan", 50));
        assertTrue(hina.getJutsus().containsKey("rasengan"));
    }

    @DisplayName("Não deve adicionar um jutsu repetido")
    @Test
    void naoDeveAdicionarJutsu() {
        hina.aprenderJutsu("rasengan", 50);

        assertEquals("Não foi possível aprender esse jutsu",
                hina.aprenderJutsu("rasengan", 50));
    }

    @DisplayName("Deve retornar os jutsus que o personagem sabe")
    @Test
    void deveRetornarJutsus() {
        hina.aprenderJutsu("rasengan", 50);
        Map<String, Integer> jutsusEsperados = new HashMap<>();
        jutsusEsperados.put("rasengan", 50);

        assertEquals(jutsusEsperados, hina.getJutsus());
    }
}