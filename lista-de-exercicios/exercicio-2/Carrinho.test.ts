import { jest } from '@jest/globals';
import { Carrinho } from './Carrinho';
import { Produto } from './Produto';

const carrinho = new Carrinho ([]);
const biscoito = new Produto ('biscoito', 3);

describe('Classe Carrinho', () => {
    test('O valor total deve ser 0 se o carrinho estiver vazio', () => {
        expect(carrinho.getValorTotal()).toBe(0);
    })

    test('Deve adicionar um produto ao carrinho', () => {
        carrinho.adicionarProdutos(biscoito);

        expect(carrinho.getLista()).toContain(biscoito);
    })

    test('Deve retornar o valor total a ser pago, considerando o desconto', () => {
        const carrinhoChinelo = new Carrinho ([])
        const chinelo = new Produto ('chinelo', 10);
        carrinhoChinelo.adicionarProdutos(chinelo);

        expect(carrinhoChinelo.getValorTotal()).toBe(10);

        chinelo.setQuantidade(11);
        expect(carrinhoChinelo.getValorTotal()).toBe(99);

        chinelo.setQuantidade(21);
        expect(carrinhoChinelo.getValorTotal()).toBe(168);

        chinelo.setQuantidade(51);
        expect(carrinhoChinelo.getValorTotal()).toBe(382.5);
    })

    test('Ao adicionar um produto mais de uma vez no carrinho, deve aumentar a quantidade do produto', () => {
        const carrinhoGarfo = new Carrinho ([]);
        const garfo = new Produto ('garfo', 4);
        carrinhoGarfo.adicionarProdutos(garfo);
        carrinhoGarfo.adicionarProdutos(garfo);

        expect(carrinhoGarfo.getLista()).toContainEqual({"nome": "garfo", "preco": 4, "quantidade": 2});
        
        carrinhoGarfo.adicionarProdutos(garfo);

        expect(carrinhoGarfo.getLista()).toContainEqual({"nome": "garfo", "preco": 4, "quantidade": 3});
    })
})