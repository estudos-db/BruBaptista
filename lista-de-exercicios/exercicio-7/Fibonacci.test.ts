import { jest } from '@jest/globals';
import { Fibonacci } from './Fibonacci';

describe('Classe Fibonacci', () => {
    test('Deve retornar um array com a série de Fibonacci do tamanho do número informado +1', () => {
        const fibonacci0 = new Fibonacci(0);
        const fibonacci1 = new Fibonacci(1);
        const fibonacci2 = new Fibonacci(2);
        const fibonacci3 = new Fibonacci(3);
        
        expect(fibonacci0.serializar()).toStrictEqual([0]);
        expect(fibonacci1.serializar()).toStrictEqual([0, 1]);
        expect(fibonacci2.serializar()).toStrictEqual([0, 1, 1]);
        expect(fibonacci3.serializar()).toStrictEqual([0, 1, 1, 2]);
    })

    test('Deve retornar um erro se entrar um número decimal ou negativo', () => {
        const fibonacciNegativo = new Fibonacci(-1);
        const fibonacciDecimal = new Fibonacci(1.2);
        const fibonacciNaN = new Fibonacci(NaN);

        expect(() => fibonacciNegativo.serializar()).toThrowError();
        expect(() => fibonacciDecimal.serializar()).toThrowError();
        expect(() => fibonacciNaN.serializar()).toThrowError();
    })
})