package org.example.exercicio10;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MatrizTest {

    Matriz matriz = new Matriz(new int[][] {
            {0, 1, 2, 3},
            {4, 5, 6, 7},
            {8, 9, 10, 11},
            {12, 13, 14, 15}
    });

    @DisplayName("Deve retornar a soma da diagonal principal de uma matriz quadrada")
    @Test
    void deveRetornarSomaDaDiagonalPrincipal() {
        assertEquals(30, matriz.somarDiagonal());
    }

    @DisplayName("Deve retornar a matriz e a soma da diagonal principal")
    @Test
    void deveRetornarStringResposta() {
        assertEquals("Dada a matriz: [[0, 1, 2, 3], [4, 5, 6, 7], [8, 9, 10, 11], [12, 13, 14, 15]]\n" +
                "A soma da diagonal principal é igual a: 30", matriz.resposta());
    }
}