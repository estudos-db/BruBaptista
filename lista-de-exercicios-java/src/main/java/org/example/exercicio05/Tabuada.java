package org.example.exercicio05;

import java.util.Arrays;

public class Tabuada {

    public String calcular(int numero) {
        int[] resultados = new int[10];

        for (int i = 0; i < 10; i ++) {
            int resultado = numero * (i + 1);
            resultados[i] = resultado;
        }
        return Arrays.toString(resultados);
    }

    public String calcularSt(int numero) {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= 10; i ++)
            sb.append(numero).append("x").append(i).append("=").append(numero * i).append("\n");
        return sb.toString();
    }
}
