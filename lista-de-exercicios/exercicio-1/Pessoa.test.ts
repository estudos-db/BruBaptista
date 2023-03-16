import { jest } from '@jest/globals';
import { Pessoa } from './Pessoa';

describe('Classe Pessoa', () => {
    test('Deve conter uma idade maior ou igual a zero', () => {
        const pessoaNegativa = new Pessoa(-10);
        const pessoaZero = new Pessoa(0);
        const pessoaDez = new Pessoa(10);

        expect(pessoaNegativa.getIdade()).toBe(0);
        expect(pessoaZero.getIdade()).toBe(0);
        expect(pessoaDez.getIdade()).toBe(10);
    })

    test('Deve retornar true se a idade for maior ou igual a 18', () => {
        const pessoaDez = new Pessoa(10);
        const pessoaDezoito = new Pessoa(18);
        const pessoaVinte = new Pessoa(20);

        expect(pessoaDez.verificar()).toBeFalsy();
        expect(pessoaDezoito.verificar()).toBeTruthy();
        expect(pessoaVinte.verificar()).toBeTruthy();
    })
})