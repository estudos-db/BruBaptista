package org.example.exercicio10;

public class Main {
    public static void main(String[] args) {
        Matriz matriz = new Matriz(new int[][] {
                {0, 1, 2, 3},
                {4, 5, 6, 7},
                {8, 9, 10, 11},
                {12, 13, 14, 15}
        });
        System.out.println(matriz.somarDiagonal());
    }
}
