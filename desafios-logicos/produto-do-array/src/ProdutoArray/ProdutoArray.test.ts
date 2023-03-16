import { jest } from "@jest/globals";
import { ProdutoArray } from './ProdutoArray';

describe('Classe ProdutoArray', () => {
    test('Deve retornar um novo array, onde cada elemento é o produto de todos os números, ' +
         'menos do número que está naquela posição no array original', () => {
        const produtoArray = new ProdutoArray([4,5,6]);
        const produto = produtoArray.multiplicador();

        expect(produto).toStrictEqual([30,24,20]);
    });

    test('Quando o tamanho do array for 2, deve retornar um novo array, ' +
         'com os números em posições invertidas do array original', () => {
        const produtoDe2 = new ProdutoArray([4,5]);
        const produto = produtoDe2.multiplicador();
        
        expect(produto).toStrictEqual([5,4]);
    });

    test('Quando o tamanho do array for 1, deve retornar um array vazio', () => {
        const produtoDe1 = new ProdutoArray([4]);
        const produto = produtoDe1.multiplicador();
        
        expect(produto).toStrictEqual([]);
    });

    test('Produtos com 0 devem retornar 0', () => {
        const produtoDe0 = new ProdutoArray([4,5,0]);
        const produto = produtoDe0.multiplicador();

        expect(produto).toStrictEqual([0,0,20]);
    });

    test('Produtos com quantidade ímpares de números negativos devem retornar números negativos', () => {
        const produtoNegativo = new ProdutoArray([-4,5,6]);
        const produto = produtoNegativo.multiplicador();

        expect(produto).toStrictEqual([30,-24,-20]);
    });

    test('Produtos com quantidade pares de números negativos devem retornar números positivos', () => {
        const produtoPositivo = new ProdutoArray([-4,-5,6]);
        const produto = produtoPositivo.multiplicador();

        expect(produto).toStrictEqual([-30,-24,20]);
    });
})