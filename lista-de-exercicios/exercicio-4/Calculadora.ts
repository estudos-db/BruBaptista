import { Menu } from './Menu.js';

export class Calculadora {
    private operacao: string;
    private numero1: number;
    private numero2: number;

    public calcular(
        numero1: number,
        numero2: number,
        operacao: string): number {
        if (!numero1 || !numero2)
            throw Error ('Número inválido');
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
                throw Error ('Operador invalido');
        }
    }
}