package org.example.exercicio13;

public class Main {
    public static void main(String[] args) {
        Aluno aluno = new Aluno(6);
        System.out.println(aluno.getStatus());

        aluno.adicionarNota(7);
        System.out.println(aluno.getMedia());
        System.out.println(aluno.getStatus());
    }
}
