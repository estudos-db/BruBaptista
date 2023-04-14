package org.example.exercicio18;

public class Guincho extends Automovel {
    private final Object[] carregando = new Object[1];

    public Guincho(int velMax) {
        super(4, velMax);
    }

    public Object[] getCarregando() {
        return carregando;
    }

    public void carregar(Automovel veiculo) {
        validarAutomovel(veiculo);
        carregando[0] = veiculo;
        System.out.println("Veículo carregado com sucesso!");
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

    private void validarAutomovel(Automovel veiculo) {
        if(!(veiculo instanceof Carro) && !(veiculo instanceof Moto))
            throw new IllegalArgumentException("O guincho só pode carregar carros e motos");
        if(carregando[0] != null)
            throw new IllegalArgumentException("O guincho já está carregando um veículo.");
    }
}
