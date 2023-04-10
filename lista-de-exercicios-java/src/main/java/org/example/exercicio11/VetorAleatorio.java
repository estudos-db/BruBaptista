package org.example.exercicio11;

import java.util.Arrays;

public class VetorAleatorio {
    private int[] numeros;

    public VetorAleatorio(int[] numeros) {
        this.numeros = numeros;
    }

    public void gerarNumeros() {
        int quantidade = this.numeros.length;
        for (int i = 0; i < quantidade; i++) {
            int aleatorio = (int) Math.floor(Math.random() * 1000);
            this.numeros[i] = aleatorio;
        }
    }

    public int[] getNumeros() {
        return numeros;
    }

    public String getString() {
        return Arrays.toString(numeros);
    }

    public void ordenar() {
        int[] array = this.numeros;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
