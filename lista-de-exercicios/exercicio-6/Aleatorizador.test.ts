import { jest } from '@jest/globals';
import { Aleatorizador } from './Aleatorizador';

const aleatorizador = new Aleatorizador();

describe('Classe Aleatorizador', () => {
    test('Deve conter um array de 10 números', () => {
        expect(aleatorizador.getAleatorios()).toHaveLength(10);
    })

    test('Deve retorar o menor e o maior númerno de um array', () => {
        expect(aleatorizador.getMaiorMenor([1,2,3])).toBe('Menor: 1\nMaior: 3');
    })
})