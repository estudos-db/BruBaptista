package org.example.exercicio20;

public class CalculoTroco {
    private int[] quantidadeDeNotas;
    private int[] quantidadeDeMoedas;
    private int resto;

    public CalculoTroco(int[] quantidadeDeNotas, int resto) {
        this.quantidadeDeNotas = quantidadeDeNotas;
        this.resto = resto;
    }

    public CalculoTroco(int[] quantidadeDeNotas, int[] quantidadeDeMoedas) {
        this.quantidadeDeNotas = quantidadeDeNotas;
        this.quantidadeDeMoedas = quantidadeDeMoedas;
    }

    public int[] getQuantidadeDeNotas() {
        return quantidadeDeNotas;
    }

    public int[] getQuantidadeDeMoedas() {
        return quantidadeDeMoedas;
    }

    public int getResto() {
        return resto;
    }
}