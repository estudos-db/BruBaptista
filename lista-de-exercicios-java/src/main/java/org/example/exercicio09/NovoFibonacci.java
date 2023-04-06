package org.example.exercicio09;

import java.util.ArrayList;

public class NovoFibonacci {

    public ArrayList<Integer> serializar(int numero) {
        ArrayList<Integer> serie = new ArrayList<>();
        int f0 = 0;
        int f1 = 1;

        validarNumero(numero);

        for (int i = 0; f0 <= numero; i++) {
            serie.add(f0);
            int f = f0 + f1;
            f0 = f1;
            f1 = f;
        }
        return serie;
    }

    private void validarNumero(int numero) {
        if (numero < 0) {
            throw new IllegalArgumentException("Número inválido");
        }
    }
}
