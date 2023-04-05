package org.example.exercicio10;

public class Matriz {
    private int[][] numeros;

    public Matriz(int[][] numeros) {
        this.numeros = numeros;
    }

    public int somar() {
        int soma = 0;
        for(int i = 0; i < this.numeros.length; i++) {
            soma += this.numeros[i][i];
        }
        return soma;
    }
}
