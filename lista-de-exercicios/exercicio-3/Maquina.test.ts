import { jest } from '@jest/globals';
import { Escolhas } from './Jokenpo.js';
import { Maquina } from './Maquina';

describe('Classe Maquina', () => {
    test('A escolha da máquina deve variar entre pedra, papel ou tesoura', () => {
        const maquina = new Maquina;

        expect([0, 1, 2]).toContain(maquina.getEscolha());
    })
})