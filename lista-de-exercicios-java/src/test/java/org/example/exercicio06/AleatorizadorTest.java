package org.example.exercicio06;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AleatorizadorTest {

    Aleatorizador aleatorizador = new Aleatorizador();
    @DisplayName("Deve gerar um array de 10 números")
    @Test
    void deveGerarArrayCom10Numeros() {
        int[] aleatorios = aleatorizador.getAleatorios(10);

        assertEquals(10, aleatorios.length);
    }

    @DisplayName("Deve dar erro se o número for negativo ou zero")
    @Test
    void deveDarErroSeNumeroForNegativoOuZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            aleatorizador.getAleatorios(-5);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            aleatorizador.getAleatorios(0);
        });
    }

    @DisplayName("Deve retornar o maior e o menor número do array")
    @Test
    void deveRetornarMaiorEMenorNumeroDoArray() {
        int[] numeros = {10, 50, 20, 30, 5};

        assertEquals("Menor: 5\nMaior: 50", aleatorizador.getMaiorMenor(numeros));
    }

    @DisplayName("Deve dar erro se o array for vazio")
    @Test
    void deveDarErroSeArrayForVazio() {
        int[] numeros = {};

        assertThrows(IllegalArgumentException.class, () -> {
            aleatorizador.getMaiorMenor(numeros);
        });
    }
}