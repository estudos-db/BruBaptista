package org.example.exercicio18;

public class Guincho extends Automovel {
    private final Object[] carregando = new Object[1];

    public Guincho(int velMax) {
        super(4, velMax);
    }

    public void carregar(Carro carro) {
        if(carregando[0] == null) {
            carregando[0] = carro;
            System.out.println("Carro carregado com sucesso!");
        }
        else
            System.out.println("O guincho já está carregando um veículo.");
    }

    public void carregar(Moto moto) {
        if(carregando[0] == null) {
            carregando[0] = moto;
            System.out.println("Moto carregada com sucesso!");
        }
        else
            System.out.println("O guincho já está carregando um veículo.");
    }

    public void soltar() {
        if(carregando[0] != null) {
            carregando[0] = null;
            System.out.println("Veículo solto com sucesso!");
        }
        else {
            System.out.println("O guincho não está carregando nenhum veículo.");
        }
    }
}
