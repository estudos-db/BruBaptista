package org.example.exercicio04;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {

    Calculadora calc = new Calculadora();

    @DisplayName("Deve retornar a soma dos 2 números")
    @Test
    public void somando() {
        double resultado = calc.calcular(2, '+', 3);
        assertEquals(5.0, resultado);
    }

    @DisplayName("Deve retornar a subtração dos 2 números")
    @Test
    public void subtraindo() {
        double resultado = calc.calcular(5, '-', 2);
        assertEquals(3.0, resultado);
    }

    @DisplayName("Deve retornar a multiplicação dos 2 números")
    @Test
    public void multiplicando() {
        double resultado = calc.calcular(2, '*', 5);
        assertEquals(10.0, resultado);
    }

    @DisplayName("Deve retornar a divisão dos 2 números")
    @Test
    public void dividindo() {
        double resultado = calc.calcular(10, '/', 2);
        assertEquals(5.0, resultado);
    }

    @DisplayName("Deve retornar erro quando o segundo número de uma divisão for zero")
    @Test
    public void dividindoZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            calc.calcular(10, '/', 0);
        });
    }

    @DisplayName("Deve retornar a potência do número 1 elevado ao número 2")
    @Test
    public void potencia() {
        double resultado = calc.calcular(2, '^', 3);
        assertEquals(8.0, resultado);
    }

    @DisplayName("Deve retornar erro quando a operação for inválida")
    @Test
    public void operadorInvalido() {
        assertThrows(IllegalArgumentException.class, () -> {
            calc.calcular(2, 'x', 3);
        });
    }
}