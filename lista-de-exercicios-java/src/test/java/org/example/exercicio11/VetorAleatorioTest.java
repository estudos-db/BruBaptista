package org.example.exercicio11;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VetorAleatorioTest {
    @DisplayName("Deve retornar um array com a quantidade escolhida de números aleatórios")
    @Test
    void deveRetornarArrayComQuantidadeDeNumerosAleatorios() {
        VetorAleatorio vetorAleatorio = new VetorAleatorio(new int[100]);
        vetorAleatorio.gerarNumeros();
        int[] vetorAleatorioArray = vetorAleatorio.getNumeros();

        assertEquals(100, vetorAleatorioArray.length);
    }

    @DisplayName("Deve retornar o array ordenado de forma crescente")
    @Test
    void deveRetornarArrayEmOrdemCrescente() {
        VetorAleatorio vetorAleatorio = new VetorAleatorio(new int[] {586, 480, 964, 843, 894, 954, 533, 221, 526, 237});
        vetorAleatorio.ordenar();

        assertArrayEquals(new int[]{221, 237, 480, 526, 533, 586, 843, 894, 954, 964}, vetorAleatorio.getNumeros());
    }
}