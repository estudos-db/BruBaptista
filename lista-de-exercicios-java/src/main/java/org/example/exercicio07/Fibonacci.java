package org.example.exercicio07;

import java.util.ArrayList;

public class Fibonacci {
    private int numero;

    public Fibonacci(int numero) {
        this.numero = numero;
    }

    public ArrayList<Integer> serializar() {
        ArrayList<Integer> serie = new ArrayList<Integer>();
        int f0 = 0;
        int f1 = 1;

        if (numero >= 0) {
            serie.add(f0);
            if (numero > 0) {
                serie.add(f1);
                for (int i = 2; i <= numero; i++) {
                    int f = f0 + f1;
                    serie.add(f);
                    f0 = f1;
                    f1 = f;
                }
            }
        } else {
            throw new IllegalArgumentException("Número inválido");
        }
        return serie;
    }
}
