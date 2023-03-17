package org.example.exercicio17;

public class TestePessoa {
    public static void main(String[] args) {
        Pessoa dionaea = new Pessoa("Dionaea", 40);
        Pessoa genlisea = new Pessoa("Genlisea", 40);
        Pessoa myrmeleo = new Pessoa("Myrmeleo", 30);
        Pessoa nepenthes = new Pessoa("Nepenthes", 30);
        Pessoa pudica = new Pessoa("Pudica", 20, genlisea, dionaea);
        Pessoa atrax = new Pessoa("Atrax", 20, nepenthes, myrmeleo);
        Pessoa mantis = new Pessoa("Mantis", 10, pudica, atrax);

        //mantis.imprime();
        //mantis.imprimePais();
        mantis.imprimeArvore();
    }
}
