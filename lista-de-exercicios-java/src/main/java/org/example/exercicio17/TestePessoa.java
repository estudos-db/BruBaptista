package org.example.exercicio17;

public class TestePessoa {
    public static void main(String[] args) {
        Pessoa allomerus = new Pessoa("Allomerus", 80);
        Pessoa pinguicula = new Pessoa("Pinguicula", 80);
        Pessoa atypus = new Pessoa("Atypus", 70);
        Pessoa rafflesia = new Pessoa("Rafflesia", 70);
        Pessoa sera = new Pessoa("Sera", 60);
        Pessoa cularia = new Pessoa("Cularia", 60);
        Pessoa vesiculo = new Pessoa("Vesiculo", 50);
        Pessoa arachnocampa = new Pessoa("Arachnocampa", 50);

        Pessoa dionaea = new Pessoa("Dionaea", 40, pinguicula, allomerus);
        Pessoa genlisea = new Pessoa("Genlisea", 40, rafflesia, atypus);
        Pessoa myrmeleo = new Pessoa("Myrmeleo", 30, cularia, sera);
        Pessoa nepenthes = new Pessoa("Nepenthes", 30, arachnocampa, vesiculo);
        Pessoa pudica = new Pessoa("Pudica", 20, genlisea, dionaea);
        Pessoa atrax = new Pessoa("Atrax", 20, nepenthes, myrmeleo);
        Pessoa mantis = new Pessoa("Mantis", 10, pudica, atrax);

        //mantis.imprimePais();
        mantis.imprimeArvore();
    }
}
