package org.example.exercicio11;

import java.util.Arrays;

public class VetorAleatorio {
    private int[] numeros;

    public VetorAleatorio(int[] numeros) {
        this.numeros = numeros;
    }

    public int[] gerarNumeros() {
        int quantidade = this.numeros.length;
        for (int i = 0; i < quantidade; i++) {
            int aleatorio = (int) Math.floor(Math.random() * 1000);
            this.numeros[i] = aleatorio;
        }
        return this.numeros;
    }

    public int[] getNumeros() {
        return numeros;
    }

    public String getString() {
        return Arrays.toString(numeros);
    }
}
