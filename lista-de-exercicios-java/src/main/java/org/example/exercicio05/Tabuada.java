package org.example.exercicio05;

import java.util.Arrays;

public class Tabuada {
    private int numero;

    public Tabuada(int numero) {
        this.numero = numero;
    }

    public String calcular() {
        int[] resultados = new int[10];

        for (int i = 0; i < 10; i ++) {
            int resultado = this.numero * (i + 1);
            resultados[i] = resultado;
        }
        return Arrays.toString(resultados);
    }

    public String calcularSt() {
        String[] resultados = new String[10];

        for (int i = 0; i < 10; i ++) {
            String resultado = this.numero + "x" + i + "=" + this.numero * (i + 1) + "\n";
            resultados[i] = resultado;
        }
        return Arrays.toString(resultados);
    }
}
