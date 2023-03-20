package org.example.exercicio19;

public class Contato {
    private String nome;
    private int numero;
    private int ddd;

    public Contato(String nome, int ddd, int numero) {
        this.nome = nome;
        this.ddd = ddd;
        this.numero = numero;
    }

    public String getContato() {
        return "Nome: " + this.nome + "\nTelefone: (" + this.ddd + ")" + this.numero;
    }
}
