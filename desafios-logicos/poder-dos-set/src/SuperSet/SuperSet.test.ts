import { jest } from "@jest/globals";
import { SuperSet } from './SuperSet';

const vetorCombinacoes = new Set<number>([1,2,3,4,5]);
const superSet = new SuperSet(vetorCombinacoes);
const combinacoes = superSet.combinar();

describe('Classe SuperSet', () => {
    test('Deve conter os números individuais', () => {
        expect(combinacoes).toContainEqual(new Set<number>([1]));
        expect(combinacoes).toContainEqual(new Set<number>([2]));
        expect(combinacoes).toContainEqual(new Set<number>([3]));
        expect(combinacoes).toContainEqual(new Set<number>([4]));
        expect(combinacoes).toContainEqual(new Set<number>([5]));
    });

    test('Deve conter as combinações dos números', () => {
        expect(combinacoes).toContainEqual(new Set<number>([1,2]));
        expect(combinacoes).toContainEqual(new Set<number>([1,2,3]));
        expect(combinacoes).toContainEqual(new Set<number>([1,2,3,4]));
    });

    test('Deve conter a si mesmo', () => {
        expect(combinacoes).toContainEqual(vetorCombinacoes);
    });

    test('Quando o tamanho do set for menor que 3, ele deve conter somente a si mesmo, seus valores individuais e um vetor vazio', () => {
        const vetorCombinacoes2 = new Set<number>([1,2]);
        const superSet = new SuperSet(vetorCombinacoes2);
        const combinacoes = superSet.combinar();

        expect(combinacoes).toContainEqual(new Set<number>([]));
        expect(combinacoes).toContainEqual(new Set<number>([1]));
        expect(combinacoes).toContainEqual(new Set<number>([2]));
        expect(combinacoes).toContainEqual(new Set<number>([1,2]));
        expect(combinacoes.size).toBe(4);
    });

    test('Quando o tamanho do set for 1, ele deve conter somente a si mesmo e um vetor vazio', () => {
        const vetorCombinacoes1 = new Set<number>([1]);
        const superSet = new SuperSet(vetorCombinacoes1);
        const combinacoes = superSet.combinar();

        expect(combinacoes).toContainEqual(new Set<number>([]));
        expect(combinacoes).toContainEqual(new Set<number>([1]));
        expect(combinacoes.size).toBe(2);
    });

    test('Quando o set for vazio, ele deve conter somente um vetor vazio', () => {
        const vetorCombinacoes0 = new Set<number>([]);
        const superSet = new SuperSet(vetorCombinacoes0);
        const combinacoes = superSet.combinar();

        expect(combinacoes).toContainEqual(new Set<number>([]));
        expect(combinacoes.size).toBe(1);
    });
});
