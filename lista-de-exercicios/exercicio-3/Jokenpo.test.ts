import { jest } from '@jest/globals';
import { Escolhas } from './Jokenpo.js';
import { Jokenpo } from './Jokenpo';
import { Jogador } from './Jogador';

const pedra = Escolhas.PEDRA;
const papel = Escolhas.PAPEL;
const tesoura = Escolhas.TESOURA;
const jogadorPedra = new Jogador(pedra);
const jogadorPapel = new Jogador(papel);
const jogadorTesoura = new Jogador(tesoura);

describe('Classe Jokenpo', () => {
    test('Pedra ganha de tesoura', () => {
        const jokenpo1 = new Jokenpo(jogadorPedra, jogadorTesoura);
        const jokenpo2 = new Jokenpo(jogadorTesoura, jogadorPedra);

        expect(jokenpo1.jogar()).toBe("Vencedor: Player 1 com PEDRA");
        expect(jokenpo2.jogar()).toBe("Vencedor: Player 2 com PEDRA");
    })

    test('Papel ganha de pedra', () => {
        const jokenpo1 = new Jokenpo(jogadorPapel, jogadorPedra);
        const jokenpo2 = new Jokenpo(jogadorPedra, jogadorPapel);

        expect(jokenpo1.jogar()).toBe("Vencedor: Player 1 com PAPEL");
        expect(jokenpo2.jogar()).toBe("Vencedor: Player 2 com PAPEL");
    })

    test('Tesoura ganha de papel', () => {
        const jokenpo1 = new Jokenpo(jogadorTesoura, jogadorPapel);
        const jokenpo2 = new Jokenpo(jogadorPapel, jogadorTesoura);

        expect(jokenpo1.jogar()).toBe("Vencedor: Player 1 com TESOURA");
        expect(jokenpo2.jogar()).toBe("Vencedor: Player 2 com TESOURA");
    })

    test('Escolhas iguais retornam empate', () => {
        const jokenpoPedra = new Jokenpo(jogadorPedra, jogadorPedra);
        const jokenpoPapel = new Jokenpo(jogadorPapel, jogadorPapel);
        const jokenpoTesoura = new Jokenpo(jogadorTesoura, jogadorTesoura);

        expect(jokenpoPedra.jogar()).toBe('Empate');
        expect(jokenpoPapel.jogar()).toBe('Empate');
        expect(jokenpoTesoura.jogar()).toBe('Empate');
    })
})