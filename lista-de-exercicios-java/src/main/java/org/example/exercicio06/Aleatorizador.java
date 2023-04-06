package org.example.exercicio06;

import java.util.Arrays;
import java.util.Random;

public class Aleatorizador {
    public String aleatorizar(int numero) {
        int[] aleatorios = this.getAleatorios(numero);
        return Arrays.toString(aleatorios) + "\n" + this.getMaiorMenor(aleatorios);
    }

    public int[] getAleatorios(int numero) {
        if(numero <= 0)
            throw new IllegalArgumentException("O número deve ser positivo.");

        int[] aleatorios = new int[numero];
        Random random = new Random();

        for (int i = 0; i < numero; i ++) {
            aleatorios[i] = random.nextInt(101);
        }
        return aleatorios;
    }

    public String getMaiorMenor(int[] numeros) {
        if (numeros == null || numeros.length == 0)
            throw new IllegalArgumentException("O array não pode ser vazio");

        int menor = 100;
        int maior = 0;
        for (int i = 0; i < numeros.length; i++) {
            if (menor > numeros[i])
                menor = numeros[i];
            if (maior < numeros[i])
                maior = numeros[i];
        }
        return "Menor: " + menor + "\nMaior: " + maior;
    }
}
