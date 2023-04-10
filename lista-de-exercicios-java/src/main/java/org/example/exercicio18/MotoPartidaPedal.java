package org.example.exercicio18;

public class MotoPartidaPedal extends Moto implements VeiculoLigavel {
    private boolean aceleradorPush;

    public MotoPartidaPedal(int velMax) {
        super(velMax);
        this.aceleradorPush = false;
    }

    public boolean isAceleradorPuxado() {
        return aceleradorPush;
    }

    @Override
    public void ligar() {
        verificarEstado(true);
        if(aceleradorPush) {
            super.ligar();
            System.out.println("A moto está ligada");
        }
        else
            throw new IllegalArgumentException("Favor puxar o acelerador ao ligar");
    }

    public void puxarAcelerador() {
        if(aceleradorPush)
            throw new IllegalArgumentException("O acelerador já está puxado");
        else {
            this.aceleradorPush = true;
            System.out.println("O acelerador está puxado");
        }
    }
}
