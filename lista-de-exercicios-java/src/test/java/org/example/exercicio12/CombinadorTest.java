package org.example.exercicio12;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CombinadorTest {
    @DisplayName("Deve retornar um novo array com todos os elementos de dois ou mais arrays")
    @Test
    void deveRetornarNovoArrayComElementosDosArrays() {
        Combinador combinador1 = new Combinador(new int[][] {{1}, {2}});
        Combinador combinador2 = new Combinador(new int[][] {{0, 1}, {2}, {3}});
        Combinador combinador3 = new Combinador(new int[][] {{1, 2}, {3, 4}, {5, 6}});

        assertArrayEquals(new int[] {1, 2}, combinador1.combinar());
        assertArrayEquals(new int[] {0, 1, 2, 3,}, combinador2.combinar());
        assertArrayEquals(new int[] {1, 2, 3, 4, 5, 6}, combinador3.combinar());
    }
}