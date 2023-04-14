package org.example.exercicio18;

public class Automovel implements VeiculoLigavel {
    private final int numRodas;
    private final double velMax;
    private boolean ligado;

    public Automovel(int numRodas, double velMax) {
        this.numRodas = numRodas;
        this.velMax = velMax;
        this.ligado = false;
    }

    public boolean isLigado() {
        return ligado;
    }

    public void ligar() {
        verificarEstado(true);
        this.ligado = true;
        System.out.println("O veículo agora está ligado");
    }

    public void desligar() {
        verificarEstado(false);
        this.ligado = false;
        System.out.println("O veículo agora está desligado");
    }
}
