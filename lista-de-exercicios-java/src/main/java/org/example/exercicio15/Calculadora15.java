package org.example.exercicio15;

public class Calculadora15 {
    public double calcular(double numero1, char operacao, double numero2) {
        if (operacao == '/' && numero2 == 0)
            throw new IllegalArgumentException("Número inválido");

        switch (operacao) {
            case '+':
                return Calculadora15.somar(numero1, numero2);
            case '-':
                return Calculadora15.subtrair(numero1, numero2);
            case '*':
                return Calculadora15.multiplicar(numero1, numero2);
            case '/':
                return Calculadora15.dividir(numero1, numero2);
            case '^':
                return Calculadora15.potencializar(numero1, numero2);
            default:
                throw new IllegalArgumentException("Operador inválido");
        }
    }

    public static double somar(double numero1, double numero2) {
        return numero1 + numero2;
    }

    public static double subtrair(double numero1, double numero2) {
        return numero1 - numero2;
    }

    public static double multiplicar(double numero1, double numero2) {
        return numero1 * numero2;
    }

    public static double dividir(double numero1, double numero2) {
        return numero1 / numero2;
    }

    public static double potencializar(double numero1, double numero2) {
        return Math.pow(numero1, numero2);
    }
}
