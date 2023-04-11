package org.example.exercicio13;

public class Main {
    public static void main(String[] args) {
        Aluno aluno = new Aluno();
        aluno.adicionarNota(6);
        aluno.calcularMedia();
        System.out.println(aluno.calcularStatus());

        aluno.adicionarNota(7);
        System.out.println(aluno.calcularMedia());
        System.out.println(aluno.calcularStatus());
    }
}
