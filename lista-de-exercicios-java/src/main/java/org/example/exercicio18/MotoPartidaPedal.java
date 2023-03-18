package org.example.exercicio18;

public class MotoPartidaPedal extends Moto{
    private boolean aceleradorPush;

    public MotoPartidaPedal(int velMax) {
        super(velMax);
        this.aceleradorPush = false;
    }

    @Override
    public void ligar() {
        if(aceleradorPush) {
            super.ligar();
            System.out.println("A moto está ligada");
        }
        else
            System.out.println("Favor puxar o acelerador ao ligar");
    }

    public void puxarAcelerador() {
        this.aceleradorPush = true;
        System.out.println("O acelerador está puxado");
    }
}
