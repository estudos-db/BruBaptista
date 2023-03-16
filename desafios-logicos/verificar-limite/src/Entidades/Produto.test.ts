import { jest } from "@jest/globals";
import { Produto } from './Produto';

describe('Produto', () => {
    test('O valor do produto não pode ser negativo', () => {
        const produtoNegativo = new Produto ('produto negativo', -10);

        expect(produtoNegativo.getValor()).toBe(0);
    })
})