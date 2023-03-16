import { jest } from '@jest/globals';
import { Matriz } from './Matriz';

const matriz = new Matriz([[1, 2, 3], [4, 5, 6], [7, 8, 9]]);

describe('Classe Matriz', () => {
    test('Deve retornar a soma da diagonal principal de uma matriz quadrada', () => {
        expect(matriz.somar()).toBe(15);
    })
})