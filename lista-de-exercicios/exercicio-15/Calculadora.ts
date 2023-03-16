import { Menu } from './../exercicio-4/Menu.js';

export class Calculadora {

    public calcular(
        numero1: number,
        numero2: number,
        operacao: string): number {
        if (!numero1 || !numero2)
            throw Error ('Número inválido');
        switch (operacao) {
            case '+':
                return Calculadora.somar(numero1, numero2);
            case '-':
                return Calculadora.subtrair(numero1, numero2);
            case '*':
                return Calculadora.multiplicar(numero1, numero2);
            case '/':
                return Calculadora.dividir(numero1, numero2);
            case '^':
                return Calculadora.potencializar(numero1, numero2);
            default: 
                throw Error ('Operador invalido');
        }
    }

    public static somar(numero1: number,
        numero2: number) {
        return numero1 + numero2;
    }

    public static subtrair(numero1: number,
        numero2: number) {
        return numero1 - numero2;
    }

    public static multiplicar(numero1: number,
        numero2: number) {
        return numero1 * numero2;
    }

    public static dividir(numero1: number,
        numero2: number) {
        return numero1 / numero2;
    }

    public static potencializar(numero1: number,
        numero2: number) {
        return Math.pow(numero1, numero2);
    }
}