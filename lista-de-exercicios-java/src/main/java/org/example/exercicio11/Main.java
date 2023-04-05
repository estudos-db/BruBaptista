package org.example.exercicio11;

public class Main {
    public static void main(String[] args) {
        VetorAleatorio vetorAleatorio = new VetorAleatorio(new int[100]);
        vetorAleatorio.gerarNumeros();
        System.out.println(vetorAleatorio.getString());
        Ordenador ordenador = new Ordenador(vetorAleatorio.getNumeros());
        ordenador.ordenar();
        System.out.println(ordenador.getString());
    }
}
