package org.example.exercicio04;

public class Calculadora {
    private char operacao;
    private double numero1;
    private double numero2;

    public double calcular(double numero1, char operacao, double numero2) {
        if (operacao == '/' && numero2 == 0)
            throw new IllegalArgumentException("Número inválido");

        this.numero1 = numero1;
        this.numero2 = numero2;
        this.operacao = operacao;

        switch (operacao) {
            case '+':
                return numero1 + numero2;
            case '-':
                return numero1 - numero2;
            case '*':
                return numero1 * numero2;
            case '/':
                return numero1 / numero2;
            case '^':
                return Math.pow(numero1, numero2);
            default:
                throw new IllegalArgumentException("Operador inválido");
        }
    }
}


