package org.example.exercicio14;

public class ConversorHoras {
    private int tempo;

    public ConversorHoras(int tempo) {
        this.tempo = tempo;
    }

    public String getHoras() {
        return this.converterHoras() + "h" + this.receberMinutos() + "min" + this.receberSegundos() + "seg";
    }

    public int receberSegundos() {
        int segundos = this.tempo % 60;
        return segundos;
    }

    public int converterMinutos() {
        int minutos = (int) Math.floor(this.tempo / 60);
        return minutos;
    }

    public int receberMinutos() {
        int minutosSobra = this.converterMinutos() % 60;
        return minutosSobra;
    }

    public int converterHoras() {
        int horas = (int) Math.floor(this.converterMinutos() / 60);
        return horas;
    }
}
