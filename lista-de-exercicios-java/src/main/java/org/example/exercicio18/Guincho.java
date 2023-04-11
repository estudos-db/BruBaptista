package org.example.exercicio18;

public class Guincho extends Automovel {
    private final Object[] carregando = new Object[1];

    public Guincho(int velMax) {
        super(4, velMax);
    }

    public Object[] getCarregando() {
        return carregando;
    }

    public void carregar(Guinchavel veiculo) {
        if(carregando[0] == null) {
            carregando[0] = veiculo;
            System.out.println("Veículo carregado com sucesso!");
        }
        else
            throw new IllegalArgumentException("O guincho já está carregando um veículo.");
    }

    public void soltar() {
        if(carregando[0] != null) {
            carregando[0] = null;
            System.out.println("Veículo solto com sucesso!");
        }
        else {
            throw new IllegalArgumentException("O guincho não está carregando nenhum veículo.");
        }
    }
}
