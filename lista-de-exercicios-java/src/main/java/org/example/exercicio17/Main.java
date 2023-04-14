package org.example.exercicio17;

public class Main {
    public static void main(String[] args) {

        Pessoa rafflesia = new Pessoa("Rafflesia", 30);
        Pessoa sera = new Pessoa("Sera", 30);
        Pessoa dionaea = new Pessoa("Dionaea", 20, rafflesia, sera);

        Pessoa myrmeleo = new Pessoa("Myrmeleo", 30);
        Pessoa nepenthes = new Pessoa("Nepenthes", 30);
        Pessoa pudica = new Pessoa("Pudica", 20, myrmeleo, nepenthes);

        Pessoa mantis = new Pessoa("Mantis", 10, pudica, dionaea);

        System.out.println(mantis.imprimeArvore());
    }
}
