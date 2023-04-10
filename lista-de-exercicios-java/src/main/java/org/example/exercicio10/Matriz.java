package org.example.exercicio10;

import java.util.Arrays;

public class Matriz {
    private int[][] numeros;

    public Matriz(int[][] numeros) {
        this.numeros = numeros;
    }

    public int somarDiagonal() {
        int soma = 0;
        for(int i = 0; i < this.numeros.length; i++) {
            soma += this.numeros[i][i];
        }
        return soma;
    }

    public String resposta() {
        StringBuilder sb = new StringBuilder();
        sb.append("Dada a matriz: ").append(Arrays.deepToString(getNumeros()))
                .append("\nA soma da diagonal principal é igual a: ").append(somarDiagonal());
        return sb.toString();
    }

    public int[][] getNumeros() {
        return numeros;
    }
}
