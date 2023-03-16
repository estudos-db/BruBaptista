import { jest } from '@jest/globals';
import { Ordenador } from './Ordenador';

const ordenador = new Ordenador(
    [586, 480, 964, 843, 894, 954, 533, 221, 526, 237]);

describe('Classe Ordenador', () => {
    test('Deve retornar o array ordenado de forma crescente', () => {
        expect(ordenador.ordenar()).toStrictEqual(
            [221, 237, 480, 526, 533, 586, 843, 894, 954, 964]);
    })
})