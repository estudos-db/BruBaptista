import { jest } from '@jest/globals';
import { VetorAleatorio } from './VetorAleatorio';

const vetorAleatorio = new VetorAleatorio([]);

describe('Classe VetorAleatorio', () => {
    test('Deve retornar um array com a quantidade escolhida de números aleatórios', () => {
        expect(vetorAleatorio.gerarNumeros(10)).toHaveLength(10);
    })
})