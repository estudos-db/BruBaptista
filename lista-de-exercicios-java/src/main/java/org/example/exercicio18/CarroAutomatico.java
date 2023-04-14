package org.example.exercicio18;

public class CarroAutomatico extends Carro {
    private boolean freioPress;

    public CarroAutomatico(int velMax) {
        super(velMax);
        this.freioPress = false;
    }

    public boolean isFreioPressionado() {
        return freioPress;
    }

    @Override
    public void ligar() {
        verificarEstado(true);
        if(freioPress) {
            super.ligar();
            System.out.println("O carro está ligado");
        }
        else
            throw new IllegalArgumentException("Favor pressionar o freio ao ligar");
    }

    public void pressionarFreio() {
        if(freioPress)
            throw new IllegalArgumentException("O freio já está pressionado");
        else {
            this.freioPress = true;
            System.out.println("O freio está pressionado");
        }
    }
}