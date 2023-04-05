package org.example.exercicio09;

import java.util.ArrayList;

public class NovoFibonacci {
    private int numero;

    public NovoFibonacci(int numero) {
        this.numero = numero;
    }

    public ArrayList<Integer> contar() {
        ArrayList<Integer> serie = new ArrayList<Integer>();
        int f0 = 0;
        int f1 = 1;
        int f = 0;

        if (this.numero >= 0) {
            serie.add(f0);
            if (this.numero > 0) {
                serie.add(f1);
                if (this.numero > 1) {
                    while (f <= this.numero) {
                        f = f0 + f1;
                        if (f <= this.numero) {
                            serie.add(f);
                            f0 = f1;
                            f1 = f;
                        }
                    }
                }
            }
        } else {
            throw new IllegalArgumentException("Número inválido");
        }
        return serie;
    }
}
