package org.example.exercicio12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Somador {
    private int[][] array;
    private int[] soma;

    public Somador(int[][] array) {
        this.array = array;
    }

    public int[] somar() {
        List<Integer> somaList = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                somaList.add(array[i][j]);
            }
        }
        soma = somaList.stream().mapToInt(Integer::intValue).toArray();
        return soma;
    }
}

