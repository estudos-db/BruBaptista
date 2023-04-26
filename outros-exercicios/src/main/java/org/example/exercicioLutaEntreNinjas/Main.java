package org.example.exercicioLutaEntreNinjas;

public class Main {
    public static void main(String[] args) {
        NinjaDeGenjutsu ninja1 = new NinjaDeGenjutsu("ninja 1");
        NinjaDeNinjutsu ninja2 = new NinjaDeNinjutsu("ninja 2");
        Jutsu bolaDeFogo = new Jutsu("Bola de fogo", 10, 5);

        ninja1.aprenderJutsu("Bola de fogo", bolaDeFogo);
        ninja2.aprenderJutsu("Bola de fogo", bolaDeFogo);
        Luta luta = new Luta(ninja1, ninja2);

        System.out.println(luta.ordenarNinjas());
    }
}
