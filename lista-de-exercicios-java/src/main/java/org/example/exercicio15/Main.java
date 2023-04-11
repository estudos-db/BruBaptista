package org.example.exercicio15;

import org.example.exercicio04.Menu;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.questoes();

        double numero1 = menu.getNumero1();
        double numero2 = menu.getNumero2();
        char operador = menu.getOperador();

        Calculadora15 calculadora = new Calculadora15();
        double resultado = calculadora.calcular(numero1, operador, numero2);
        System.out.println("Resultado: " + resultado);
    }
}
