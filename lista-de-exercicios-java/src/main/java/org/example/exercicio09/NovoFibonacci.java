package org.example.exercicio09;

import java.util.ArrayList;

public class NovoFibonacci {

    public ArrayList<Integer> serializar(int numero) {
        ArrayList<Integer> serie = new ArrayList<>();
        int f0 = 0;
        int f1 = 1;

        validarNumero(numero);

        int i = 0;
        do {
            serie.add(f0);
            int f = f0 + f1;
            f0 = f1;
            f1 = f;
            i++;
        } while (f0 <= numero);

        return serie;
    }

    private void validarNumero(int numero) {
        if (numero < 0) {
            throw new IllegalArgumentException("Número inválido");
        }
    }
}