package org.example.exercicio06;

import java.util.Arrays;
import java.util.Random;

public class Aleatorizador {
    public String aleatorizar(int numero) {
        int[] aleatorios = this.getAleatorios(numero);
        String menorMaior = this.getMaiorMenor(this.getAleatorios(numero));
        return Arrays.toString(aleatorios) + "\n" + menorMaior;
    }

    public int[] getAleatorios(int numero) {
        if(numero <= 0)
            throw new IllegalArgumentException("O número deve ser positivo.");

        int[] aleatorios = new int[numero];

        for (int i = 0; i < 10; i ++) {
            Random random = new Random();
            int aleatoria = random.nextInt(101);
            aleatorios[i] = aleatoria;
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
