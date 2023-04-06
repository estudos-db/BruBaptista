package org.example.exercicio07;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {

    @DisplayName("Deve retornar um array com a série de Fibonacci do tamanho do número informado +1")
    @Test
    void deveRetornarArrayDoTamanhoMais1() {
        Fibonacci fibo = new Fibonacci();
        ArrayList<Integer> fiboArray = fibo.serializar(1);

        assertEquals(2, fiboArray.size());
    }


    @DisplayName("Deve retornar o array correto")
    @Test
    void deveRetornarArrayCorreto() {
        Fibonacci fibo = new Fibonacci();
        ArrayList<Integer> fiboArray = fibo.serializar(9);

        assertArrayEquals(new Integer[] {0, 1, 1, 2, 3, 5, 8, 13, 21, 34}, fibo.serializar(9).toArray());
    }

    @DisplayName("Deve retornar um erro se entrar um número negativo")
    @Test
    void deveRetornarErroComNumeroNegativo() {
        Fibonacci fibo = new Fibonacci();

        assertThrows(IllegalArgumentException.class, () -> {
            fibo.serializar(-2);
        });
    }
}