package org.example.exercicio09;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class NovoFibonacciTest {
    @DisplayName("Deve retornar um array onde o último número é menor ou igual ao número informado")
    @Test
    void deveRetornarArrayAteNumeroInformadoOuMenor() {
        NovoFibonacci novoFibo = new NovoFibonacci(2);
        ArrayList<Integer> novoFiboArray = novoFibo.contar();

        assertEquals(4, novoFiboArray.size());
    }

    @DisplayName("Deve retornar um erro se entrar um número negativo")
    @Test
    void deveRetornarErroComNumeroNegativo() {
        NovoFibonacci novoFibo = new NovoFibonacci(-2);

        assertThrows(IllegalArgumentException.class, novoFibo::contar);
    }
}