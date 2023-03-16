import { jest } from '@jest/globals';
import { Calculadora } from './Calculadora';

const calculadora = new Calculadora;

describe('Classe Calculadora', () => {
    test('Deve retornar a soma dos dois números', () => {
        expect(calculadora.calcular(1, 1, '+')).toBe(2);
    })

    test('Deve retornar a subtração dos dois números', () => {
        expect(calculadora.calcular(1, 1, '-')).toBe(0);
    })

    test('Deve retornar a multiplicação dos dois números', () => {
        expect(calculadora.calcular(2, 2, '*')).toBe(4);
    })

    test('Deve retornar a divisão dos dois números', () => {
        expect(calculadora.calcular(4, 2, '/')).toBe(2);
    })
    
    test('Deve retornar a potencialização de dois números', () => {
        expect(calculadora.calcular(2, 3, '^')).toBe(8);
    })

    test('Deve retornar um erro se não entrar uma operação disponível', () => {
        expect(() => calculadora.calcular(1, 1, 'a')).toThrowError();
    })

    test('Deve retornar um erro se não entrar um número', () => {
        let numeroUndefined: number;

        expect(() => calculadora.calcular(NaN, 1, '+')).toThrowError();
        expect(() => calculadora.calcular(numeroUndefined, 1, '-')).toThrowError();
        expect(() => calculadora.calcular(1, NaN, '*')).toThrowError();
        expect(() => calculadora.calcular(1, numeroUndefined, '/')).toThrowError();
    })
})