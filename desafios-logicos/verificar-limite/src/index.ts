import { Carrinho } from './Entidades/Carrinho.js';
import { Produto } from './Entidades/Produto.js';
import { Usuario } from './Entidades/Usuario.js';

const pedro = new Usuario (40);

const arroz = new Produto ('arroz', 25);
const feijao = new Produto ('feijao', 10);
const refrigerante = new Produto ('refrigerante', 5);
const deckYugioh = new Produto ('deck de yugioh', 550);

const carrinho = new Carrinho (pedro, []);

carrinho.adicionarProdutos(arroz);
carrinho.adicionarProdutos(feijao);

console.log(carrinho.getLista());
console.log(carrinho.getValorTotal());
console.log(carrinho.verificarLimite());

carrinho.adicionarProdutos(refrigerante);

console.log(carrinho.getLista());
console.log(carrinho.getValorTotal());
console.log(carrinho.verificarLimite());

carrinho.adicionarProdutos(deckYugioh);

console.log(carrinho.getLista());
console.log(carrinho.getValorTotal());
console.log(carrinho.verificarLimite());