package org.example.exercicio18;

public class Automovel {
    private final int numRodas;
    private final int velMax;
    private boolean ligado;

    public Automovel(int numRodas, int velMax) {
        this.numRodas = numRodas;
        this.velMax = velMax;
        this.ligado = false;
    }

    public void ligar() {
        this.ligado = true;
        System.out.println("O veículo agora está ligado");
    }

    public void desligar() {
        if(this.ligado) {
            this.ligado = false;
            System.out.println("O veículo agora está desligado");
        } else
            System.out.println("O veículo já está desligado");
    }
}
