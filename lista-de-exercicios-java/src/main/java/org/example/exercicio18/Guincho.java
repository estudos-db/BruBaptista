package org.example.exercicio18;

public class Guincho extends Automovel {
    private final Object[] carregando = new Object[1];

    public Guincho(int velMax) {
        super(4, velMax);
    }

    public void carregar(Automovel automovel) {
        if(carregando[0] == null) {
            carregando[0] = automovel;
            System.out.println("Veículo carregado com sucesso!");
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
