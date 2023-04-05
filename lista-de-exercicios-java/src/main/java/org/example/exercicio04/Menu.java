package org.example.exercicio04;
import java.util.Scanner;

public class Menu {
    private char operador;
    private double numero1;
    private double numero2;

    public void questoes() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o primeiro número:");
        numero1 = scanner.nextDouble();
        System.out.println("Escolha um operador para calcular:");
        System.out.println("+: para somar");
        System.out.println("-: para subtrair");
        System.out.println("*: para multiplicar");
        System.out.println("/: para dividir");
        System.out.println("^: para potencializar");
        operador = scanner.next().charAt(0);
        System.out.println("Digite o segundo número:");
        numero2 = scanner.nextDouble();
    }

    public char getOperador() {
        return operador;
    }

    public double getNumero1() {
        return numero1;
    }

    public double getNumero2() {
        return numero2;
    }
}
