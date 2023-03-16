import { jest } from '@jest/globals';
import { Escolhas } from './Jokenpo.js';
import { Jogador } from './Jogador';

const pedra = Escolhas.PEDRA;
const papel = Escolhas.PAPEL;
const tesoura = Escolhas.TESOURA;

describe('Classe Jogador', () => {
    test('A escolha do jogador deve ser pedra, papel ou tesoura', () => {
        const jogadorPedra = new Jogador(pedra);

        expect(jogadorPedra.getEscolha()).toBe(pedra);

        const jogadorPapel = new Jogador(papel);

        expect(jogadorPapel.getEscolha()).toBe(papel);

        const jogadorTesoura = new Jogador(tesoura);

        expect(jogadorTesoura.getEscolha()).toBe(tesoura);
    })
})