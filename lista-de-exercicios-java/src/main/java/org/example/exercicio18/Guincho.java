package org.example.exercicio18;

import org.example.exercicio18.Automovel;

public class Guincho extends Automovel {
    private Object[] carregando = new Object[1];

    public Guincho(int velMax) {
        super(4, velMax);
    }

    public void carregar(Carro carro) {
        if(carregando.length == 0) {
            carregando[0] = carro;
            System.out.println("Carro carregado com sucesso!");
        }
        else
            System.out.println("O guincho já está carregando um veículo.");
    }

    public void carregar(Moto moto) {
        if(carregando.length == 0) {
            carregando[0] = moto;
            System.out.println("Moto carregada com sucesso!");
        }
        else
            System.out.println("O guincho já está carregando um veículo.");
    }
}
