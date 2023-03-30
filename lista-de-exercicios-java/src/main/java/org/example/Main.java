package org.example;

import org.example.exercicio01.Pessoa;

public class Main {
    public static void main(String[] args) {
        Pessoa rafflesia = new Pessoa("Rafflesia", 18);
        Pessoa sera = new Pessoa("Sera", 16);

        System.out.println(rafflesia.verificarIdade());
        System.out.println(sera.verificarIdade());
    }
}