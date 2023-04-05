package org.example.exercicio11;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OrdenadorTest {
    @DisplayName("Deve retornar o array ordenado de forma crescente")
    @Test
    void deveRetornarArrayEmOrdemCrescente() {
        Ordenador ordenador = new Ordenador(new int[] {586, 480, 964, 843, 894, 954, 533, 221, 526, 237});

        assertArrayEquals(new int[]{221, 237, 480, 526, 533, 586, 843, 894, 954, 964}, ordenador.ordenar());
    }
}