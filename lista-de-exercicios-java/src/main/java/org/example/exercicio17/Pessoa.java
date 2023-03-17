package org.example.exercicio17;

public class Pessoa {
    private final String nome;
    private final int idade;
    private Pessoa pai;
    private Pessoa mae;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public Pessoa(String nome, int idade, Pessoa pai, Pessoa mae) {
        this.nome = nome;
        this.idade = idade;
        this.pai = pai;
        this.mae = mae;
    }

    public void imprime() {
        System.out.println("Nome: " + this.nome + ", idade: " + this.idade);
    }

    public void imprimePais() {
        System.out.print("Nome: " + this.nome + "\nPai: ");
        if(this.pai != null)
            System.out.print(this.pai.nome);
        else
            System.out.print("Desconhecido");
        System.out.print(", mae: ");
        if(this.mae != null)
            System.out.print(this.mae.nome);
        else
            System.out.print("Desconhecida");
    }

    public void imprimeArvore() {
        imprimeArvore(0);
    }
    private void imprimeArvore(int ancestralidade) {
        System.out.println("\nAncestralidade: " + ancestralidade);
        imprimePais();
        if(this.pai != null) {
            System.out.println();
            this.pai.imprimeArvore(ancestralidade +1);
        }
        if(this.mae != null) {
            System.out.println();
            this.mae.imprimeArvore(ancestralidade +1);
        }
    }
}