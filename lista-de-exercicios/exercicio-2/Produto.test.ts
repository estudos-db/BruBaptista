import { jest } from '@jest/globals';
import { Produto } from './Produto'

describe('Classe Produto', () => {
    test('Não deve conter um preço negativo', () => {
        const precoNegativo = new Produto ('batata', -10);

        expect(precoNegativo.getPreco()).toBe(0);
    })

    test('Não deve conter uma quantidade negativa', () => {
        const quantidadeNegativa = new Produto ('tomate', 10, -1);

        expect(quantidadeNegativa.getQuantidade()).toBe(1);
    })

    test('Se a quantidade não for informada, deve ser igual a 1', () => {
        const quantidadeVazia = new Produto ('batata', 10);

        expect(quantidadeVazia.getQuantidade()).toBe(1);
    })

    test('Deve diminuir o valor total de acordo com a quantidade de produtos iguais', () => {
        const algo = new Produto ('algo', 10);
        
        expect(algo.getPreco()).toBe(10);

        algo.setQuantidade(11);

        expect(algo.getPreco()).toBe(99);

        algo.setQuantidade(21);

        expect(algo.getPreco()).toBe(168);

        algo.setQuantidade(51);

        expect(algo.getPreco()).toBe(382.5);
    })
})