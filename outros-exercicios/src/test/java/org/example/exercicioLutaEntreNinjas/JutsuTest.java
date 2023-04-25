package org.example.exercicioLutaEntreNinjas;

import org.example.exercicioNaruto.Personagem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class JutsuTest {

    @DisplayName("Deve retornar erro ao tentar criar um jutsu com dano menor que 0 ou maior que 10")
    @Test
    void deveRetornarErroJutsuComDanoMenorQueZeroOuMaiorQueDez() {
        assertThrows(IllegalArgumentException.class, () -> {
            Jutsu jutsuZero = new Jutsu("zero", -1, 5);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Jutsu jutsuDez = new Jutsu("dez", 11, 5);
        });
    }

    @DisplayName("Deve retornar erro ao tentar criar um jutsu com consumo de chakra menor que 0 ou maior que 10")
    @Test
    void deveRetornarErroJutsuComConsumoDeChakraMenorQueZeroOuMaiorQueDez() {
        assertThrows(IllegalArgumentException.class, () -> {
            Jutsu jutsuZero = new Jutsu("zero", 5, -1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Jutsu jutsuDez = new Jutsu("dez", 5, 11);
        });
    }
}