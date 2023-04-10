package org.example.exercicio18;

public interface VeiculoLigavel {
    void ligar();
    void desligar();
    boolean isLigado();
    default void verificarEstado(boolean estado) {
        boolean ligado = isLigado();
        if(estado == ligado) {
            if(estado)
                throw new IllegalArgumentException("O veículo já está ligado");
            else
                throw new IllegalArgumentException("O veículo já está desligado");
        }
    }
}