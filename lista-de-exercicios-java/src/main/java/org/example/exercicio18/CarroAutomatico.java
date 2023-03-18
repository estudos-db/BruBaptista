package org.example.exercicio18;

public class CarroAutomatico extends Carro {
    private boolean freioPress;

    public CarroAutomatico(int velMax) {
        super(velMax);
        this.freioPress = false;
    }

    @Override
    public void ligar() {
        if(freioPress) {
            super.ligar();
            System.out.println("O carro está ligado");
        }
        else
            System.out.println("Favor pressionar o freio ao ligar");
    }

    public void pressionarFreio() {
        this.freioPress = true;
        System.out.println("O freio está pressionado");
    }
}
