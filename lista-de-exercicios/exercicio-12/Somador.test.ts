import { jest } from '@jest/globals';
import { Somador } from './Somador';

describe('Classe Somador', () => {
    test('Deve retornar um novo array com todos os elementos de dois ou mais arrays', () => {
        const somador2 = new Somador([[1], [2]]);

        expect(somador2.somar()).toStrictEqual([1, 2]);

        const somador3 = new Somador([[0, 1], [2], [3]]);

        expect(somador3.somar()).toStrictEqual([0, 1, 2, 3]);

        const somador4 = new Somador([[0, 1], [2], [3], [4, 5, 6]]);

        expect(somador4.somar()).toStrictEqual([0, 1, 2, 3, 4, 5, 6]);
    })
})