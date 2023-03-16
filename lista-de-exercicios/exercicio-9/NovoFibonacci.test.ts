import { jest } from '@jest/globals';
import { NovoFibonacci } from './NovoFibonacci';

describe('Classe NovoFibonacci', () => {
    test('Deve retornar um array onde o último número é menor ou igual ao número informado', () => {
        const novoFibonacci0 = new NovoFibonacci(0);
        const novoFibonacci1 = new NovoFibonacci(1);
        const novoFibonacci2 = new NovoFibonacci(2);

        expect(novoFibonacci0.contar()).toStrictEqual([0]);
        expect(novoFibonacci1.contar()).toStrictEqual([0, 1]);
        expect(novoFibonacci2.contar()).toStrictEqual([0, 1, 1, 2]);
    })

    test('Deve retornar um erro se entrar um número decimal ou negativo', () => {
        const novoFibonacciNegativo = new NovoFibonacci(-1);
        const novoFibonacciDecimal = new NovoFibonacci(1.2);
        const novoFibonacciNaN = new NovoFibonacci(NaN);

        expect(() => novoFibonacciNegativo.contar()).toThrowError();
        expect(() => novoFibonacciDecimal.contar()).toThrowError();
        expect(() => novoFibonacciNaN.contar()).toThrowError();
    })
})