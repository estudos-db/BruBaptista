package org.example.exercicio13;

import java.util.ArrayList;

public class Aluno {
    private double nota;
    private ArrayList<Double> notas;
    private double media;
    private String status;

    public Aluno() {
        this.notas = new ArrayList<>();
    }

    public void adicionarNota(double nota) {
        if (nota < 0 || nota > 10) {
            throw new IllegalArgumentException("A nota deve estar entre 0 e 10.");
        }
        this.notas.add(nota);
    }

    public ArrayList<Double> getNotas() {
        return notas;
    }

    public double calcularMedia() {
        double soma = 0;
        for (double nota : notas)
            soma += nota;
        this.media = soma / this.notas.size();
        return this.media;
    }


    public String calcularStatus() {
        if (this.media > 6)
            this.status = "Aprovado";
        else if (this.media >= 4)
            this.status = "Verificação Suplementar";
        else this.status = "Reprovado";
        return this.status;
    }

    public double getMedia() {
        return this.media;
    }

    public String getStatus() {
        return this.status;
    }
}
