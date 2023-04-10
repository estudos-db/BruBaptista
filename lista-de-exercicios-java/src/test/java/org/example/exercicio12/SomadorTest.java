package org.example.exercicio12;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SomadorTest {
    @DisplayName("Deve retornar um novo array com todos os elementos de dois ou mais arrays")
    @Test
    void deveRetornarNovoArrayComElementosDosArrays() {
        Somador somador1 = new Somador(new int[][] {{1}, {2}});
        Somador somador2 = new Somador(new int[][] {{0, 1}, {2}, {3}});
        Somador somador3 = new Somador(new int[][] {{1, 2}, {3, 4}, {5, 6}});

        assertArrayEquals(new int[] {1, 2}, somador1.somar());
        assertArrayEquals(new int[] {0, 1, 2, 3,}, somador2.somar());
        assertArrayEquals(new int[] {1, 2, 3, 4, 5, 6}, somador3.somar());
    }
}