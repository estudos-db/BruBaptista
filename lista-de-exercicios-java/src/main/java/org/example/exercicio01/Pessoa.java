package org.example.exercicio01;

public class Pessoa {
    private String nome;
    private int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.validarIdade(idade);
    }

    private int validarIdade(int idade) {
        if (idade <= 0)
            this.idade = 0;
        else
            this.idade = idade;
        return idade;
    }

    public int getIdade() {
        return idade;
    }

    public boolean verificarIdade() {
        return 18 <= this.idade;
    }
}
