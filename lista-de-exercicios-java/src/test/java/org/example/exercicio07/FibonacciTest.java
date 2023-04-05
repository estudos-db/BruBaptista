package org.example.exercicio07;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {

    @DisplayName("Deve retornar um array com a série de Fibonacci do tamanho do número informado +1")
    @Test
    void deveRetornarArrayDoTamanhoMais1() {
        Fibonacci fibo = new Fibonacci(1);
        ArrayList<Integer> fiboArray = fibo.serializar();

        assertEquals(2, fiboArray.size());
    }

    @DisplayName("Deve retornar um erro se entrar um número negativo")
    @Test
    void deveRetornarErroComNumeroNegativo() {
        Fibonacci fibo = new Fibonacci(-2);

        assertThrows(IllegalArgumentException.class, () -> {
            fibo.serializar();
        });
    }
}