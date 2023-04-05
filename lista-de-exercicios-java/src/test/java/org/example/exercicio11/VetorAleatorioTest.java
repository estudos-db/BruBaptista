package org.example.exercicio11;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VetorAleatorioTest {
    @DisplayName("Deve retornar um array com a quantidade escolhida de números aleatórios")
    @Test
    void deveRetornarArrayComQuantidadeDeNumerosAleatorios() {
        VetorAleatorio vetorAleatorio = new VetorAleatorio(new int[100]);
        int[] vetorAleatorioArray = vetorAleatorio.gerarNumeros();

        assertEquals(100, vetorAleatorioArray.length);
    }
}