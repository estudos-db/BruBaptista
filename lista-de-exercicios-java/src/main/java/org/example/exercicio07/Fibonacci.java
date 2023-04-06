package org.example.exercicio07;

import java.util.ArrayList;

public class Fibonacci {

    public ArrayList<Integer> serializar(int numero) {
        ArrayList<Integer> serie = new ArrayList<>();
        int f = 0;

        if (numero >= 0) {
            for (int i = 0; i <= numero; i++) {
                serie.add(f);
                int proximo;
                if (i == 0)
                    proximo = 1;
                else
                    proximo = serie.get(i - 1) + f;
                f = proximo;
            }
        } else {
            throw new IllegalArgumentException("Número inválido");
        }
        return serie;
    }
}
