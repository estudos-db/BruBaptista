package org.example.exercicio04;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.questoes();

        double numero1 = menu.getNumero1();
        double numero2 = menu.getNumero2();
        char operador = menu.getOperador();

        Calculadora calculadora = new Calculadora();
        double resultado = calculadora.calcular(numero1, operador, numero2);
        System.out.println("Resultado: " + resultado);
    }
}