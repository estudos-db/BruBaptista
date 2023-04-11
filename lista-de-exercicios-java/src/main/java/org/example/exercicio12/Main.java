package org.example.exercicio12;

import org.example.exercicio11.VetorAleatorio;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        VetorAleatorio vetor1 = new VetorAleatorio(new int[50]);
        vetor1.gerarNumeros();
        System.out.println(vetor1.getString());
        vetor1.ordenar();
        System.out.println(vetor1.getString());
        System.out.println();

        VetorAleatorio vetor2 = new VetorAleatorio(new int[50]);
        vetor2.gerarNumeros();
        System.out.println(vetor2.getString());
        vetor2.ordenar();
        System.out.println(vetor2.getString());
        System.out.println();

        Combinador combinador = new Combinador(new int[][] {vetor1.getNumeros(), vetor2.getNumeros()});
        int[] arraysCombinados = combinador.combinar();
        System.out.println(Arrays.toString(arraysCombinados));

        VetorAleatorio vetor3 = new VetorAleatorio(arraysCombinados);
        vetor3.ordenar();
        System.out.println(vetor3.getString());
    }
}
