package org.example.exercicio08;
import java.util.Scanner;

public class Loop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numero;

        do {
            System.out.println("Digite um número: ");
            numero = scanner.nextInt();
        } while(numero != 10);

        System.out.println("Você digitou o número 10!");
    }
}