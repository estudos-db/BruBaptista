package org.example.exercicio08;
import java.util.Scanner;

public class Loop {
    private int resposta;
    private Scanner scanner;

    public Loop() {
        this.scanner = new Scanner(System.in);
    }

    public void loopar(int numero) {
        int contagem = 0;
        while (this.resposta != numero) {
            System.out.println("Contador: " + contagem++);
            while (!scanner.hasNextInt()) {
                System.out.println("Digite um número inteiro válido: ");
                scanner.next();
            }
            int outraResposta = scanner.nextInt();
            this.resposta = outraResposta;
        }
    }
}
