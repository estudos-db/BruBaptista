package org.example.exercicio13;

import java.util.ArrayList;

public class Aluno {
    private double nota;
    private ArrayList<Double> notas;
    private double media;
    private String status;

    public Aluno(double nota) {
        this.notas = new ArrayList<Double>();
        this.notas.add(setNota(nota));
        this.getMedia();
        this.getStatus();
    }

    public double setNota(double nota) {
        this.nota = nota;
        if (nota <= 0)
            throw new IllegalArgumentException("Uma nota não pode ser menor que zero.");
        else if (nota >= 10)
            throw new IllegalArgumentException("Uma nota não pode ser maior que dez.");
        return nota;
    }

    public ArrayList<Double> getNotas() {
        return notas;
    }

    public void adicionarNota(double nota) {
        this.notas.add(nota);
    }

    public double getMedia() {
        double soma = 0;
        for (int i = 0; i < this.notas.size(); i ++) {
            soma += this.notas.get(i);
        }
        this.media = soma / this.notas.size();
        return this.media;
    }

    public String getStatus() {
        this.getMedia();
        if (this.media > 6)
            this.status = "Aprovado";
        else if (this.media >= 4)
            this.status = "Verificacao Suplementar";
        else this.status = "Reprovado";
        return this.status;
    }
}
