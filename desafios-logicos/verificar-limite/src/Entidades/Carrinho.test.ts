import { jest } from "@jest/globals";
import { Carrinho } from './Carrinho';
import { Produto } from "./Produto";
import { Usuario } from "./Usuario";

const usuario = new Usuario (0);
const carrinho = new Carrinho (usuario, []);
const queijo = new Produto ('queijo', 15);
const vinho = new Produto ('vinho', 35);
const batom = new Produto('batom', 50);

describe('Carrinho', () => {
    test('O valor total deve ser 0 se o carrinho estiver vazio', () => {
        expect(carrinho.getValorTotal()).toBe(0);
    })

    test('Deve adicionar um produto ao carrinho', () => {
        carrinho.adicionarProdutos(batom);

        expect(carrinho.getLista()).toContain(batom);
    })

    test('Deve retornar o valor total a ser pago', () => {
        const carrinhoQueijo = new Carrinho (usuario, [])
        carrinhoQueijo.adicionarProdutos(queijo);

        expect(carrinhoQueijo.getValorTotal()).toBe(15);
    })

    test('Deve retornar true se o valor total for menor ou igual ao limite', () => {
        const usuario50 = new Usuario (50);
        const carrinho50 = new Carrinho (usuario50, []);
        carrinho50.adicionarProdutos(queijo);

        expect(carrinho50.verificarLimite()).toBeTruthy;

        carrinho50.adicionarProdutos(vinho);

        expect(carrinho50.verificarLimite()).toBeTruthy;

        carrinho50.adicionarProdutos(batom);

        expect(carrinho50.verificarLimite()).toBeFalsy;
    })
})