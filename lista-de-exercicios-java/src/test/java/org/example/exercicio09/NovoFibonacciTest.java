package org.example.exercicio09;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class NovoFibonacciTest {
    @DisplayName("Deve retornar um array onde o último número é menor ou igual ao número informado")
    @Test
    void deveRetornarArrayAteNumeroInformadoOuMenor() {
        NovoFibonacci novoFibo = new NovoFibonacci();
        ArrayList<Integer> novoFiboArray = novoFibo.serializar(2);

        assertEquals(4, novoFiboArray.size());
    }

    @DisplayName("Deve retornar o array correto")
    @Test
    void deveRetornarArrayCorreto() {
        NovoFibonacci novoFibo = new NovoFibonacci();

        assertArrayEquals(new Integer[] {0, 1, 1, 2, 3, 5, 8, 13, 21}, novoFibo.serializar(25).toArray());
    }

    @DisplayName("Deve retornar um erro se entrar um número negativo")
    @Test
    void deveRetornarErroComNumeroNegativo() {
        NovoFibonacci novoFibo = new NovoFibonacci();

        assertThrows(IllegalArgumentException.class, () -> novoFibo.serializar(-2));
    }
}