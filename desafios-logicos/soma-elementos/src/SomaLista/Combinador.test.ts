import { jest } from '@jest/globals'
import { Combinador } from './Combinador'

const vetorCombinacoes = [1,2,3,4,5];
const combinador = new Combinador(vetorCombinacoes);
const combinacoes = combinador.combinar();

describe('Classe Combinador', () => {
    test('Não deve conter os números individuais', () => {
        expect(combinacoes).not.toContainEqual([1]);
        expect(combinacoes).not.toContainEqual([2]);
        expect(combinacoes).not.toContainEqual([3]);
        expect(combinacoes).not.toContainEqual([4]);
        expect(combinacoes).not.toContainEqual([5]);
    });

    test('Deve conter as combinações dos números', () => {
        expect(combinacoes).toContainEqual([1,2]);
        expect(combinacoes).toContainEqual([1,2,3]);
        expect(combinacoes).toContainEqual([1,2,3,4]);
    });

    test('Deve conter a si mesmo', () => {
        expect(combinacoes).toContainEqual(vetorCombinacoes);
    });

    test('Quando o tamanho do array for menor que 3, deve conter somente a si mesmo', () => {
        const vetorCombinacoes2 = [1,2];
        const combinador = new Combinador(vetorCombinacoes2);
        const combinacoes = combinador.combinar();

        expect(combinacoes).not.toContainEqual([]);
        expect(combinacoes).not.toContainEqual([1]);
        expect(combinacoes).not.toContainEqual([2]);
        expect(combinacoes).toContainEqual([1,2]);
        expect(combinacoes).toHaveLength(1);
    });

    test('Quando o tamanho do array for 1, ele não deve conter combinações', () => {
        const vetorCombinacoes1 = [1];
        const combinador = new Combinador(vetorCombinacoes1);
        const combinacoes = combinador.combinar();

        expect(combinacoes).not.toContainEqual([]);
        expect(combinacoes).not.toContainEqual([1]);
        expect(combinacoes).toHaveLength(0);
    });

    test('Quando o array for vazio, ele não deve conter combinações', () => {
        const vetorCombinacoes0 = [];
        const combinador = new Combinador(vetorCombinacoes0);
        const combinacoes = combinador.combinar();
        
        expect(combinacoes).not.toContainEqual([]);
        expect(combinacoes).toHaveLength(0);
    });
});