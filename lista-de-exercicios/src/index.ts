// Exercício 1
// import { Pessoa } from './../exercicio-1/Pessoa.js';

// const pessoa = new Pessoa(18);
// const pessoaMenor = new Pessoa(16);
// console.log(pessoa.verificar());
// console.log(pessoaMenor.verificar());

// Exercício 2
import { Produto } from './../exercicio-2/Produto.js';
import { Carrinho } from './../exercicio-2/Carrinho.js';

const mouse = new Produto('mouse', 8);
const carrinho = new Carrinho([mouse]);
console.log(carrinho.getValorTotal());

mouse.setQuantidade(11);
console.log(carrinho.getValorTotal());
mouse.setQuantidade(21);
console.log(carrinho.getValorTotal());
mouse.setQuantidade(51);
console.log(carrinho.getValorTotal());

// Exercício 3
// import { Escolhas } from './../exercicio-3/Jokenpo.js';
// import { Jokenpo } from './../exercicio-3/Jokenpo.js';
// import { Jogador } from './../exercicio-3/Jogador.js';
// import { Maquina } from './../exercicio-3/Maquina.js';

// const pedra = Escolhas.PEDRA;
// const papel = Escolhas.PAPEL;
// const tesoura = Escolhas.TESOURA;
// const jogador = new Jogador(pedra);
// const maquina = new Maquina();
// const jokenpo = new Jokenpo(jogador, maquina);

// console.log(jokenpo.jogar());

// Exercício 4
// import { Menu } from './../exercicio-4/Menu.js';
// import { Calculadora } from './../exercicio-4/Calculadora.js';

// const menu = new Menu();
// const calculadora = new Calculadora();

// menu.questoes();
// console.log(calculadora.calcular(
//     menu.getNumero1(),
//     menu.getNumero2(),
//     menu.getOperador()));

// Exercício 5
// import { Tabuada } from './../exercicio-5/Tabuada.js';

// const tabuada = new Tabuada(2);

// console.log(tabuada.calcular());
// console.log(tabuada.calcularSt());

// Exercício 6
// import { Aleatorizador } from './../exercicio-6/Aleatorizador.js';

// const aleatorizador = new Aleatorizador();

// console.log(aleatorizador.aleatorizar());

// Exercício 7
// import { Fibonacci } from './../exercicio-7/Fibonacci.js';

// const fibonacci = new Fibonacci(9);

// console.log(fibonacci.serializar());

// Exercício 8
// import { Loop } from "../exercicio-8/Loop.js";

// const loop = new Loop()
// loop.loopar();

// Exercício 9
// import { NovoFibonacci } from './../exercicio-9/NovoFibonacci.js';

// const novoFibonacci = new NovoFibonacci(25);

// console.log(novoFibonacci.contar());

// Exercício 10
// import { Matriz } from "../exercicio-10/Matriz.js";

// const matriz = new Matriz(
//     [[0, 1, 2, 3],
//     [4, 5, 6, 7],
//     [8, 9, 10, 11],
//     [12, 13, 14, 15]]);

//     console.log(matriz.somar());

// Exercício 11
// import { VetorAleatorio } from './../exercicio-11/VetorAleatorio.js';
// import { Ordenador } from '../exercicio-11/Ordenador.js';

// const vetorAleatorio = new VetorAleatorio([]);
// console.log(vetorAleatorio.gerarNumeros(100));

// const ordenador = new Ordenador(vetorAleatorio.getArray());
// console.log(ordenador.ordenar());

// Exercício 12
// import { VetorAleatorio } from './../exercicio-11/VetorAleatorio.js';
// import { Ordenador } from '../exercicio-11/Ordenador.js';
// import { Somador } from '../exercicio-12/Somador.js';

// const vetor1 = new VetorAleatorio([]);
// console.log(vetor1.gerarNumeros(50));
// const ordenador1 = new Ordenador(vetor1.getArray());
// console.log(ordenador1.ordenar());

// const vetor2 = new VetorAleatorio([]);
// console.log(vetor2.gerarNumeros(50));
// const ordenador2 = new Ordenador(vetor2.getArray());
// console.log(ordenador2.ordenar());

// const somador = new Somador([vetor1.getArray(), vetor2.getArray()]);
// console.log(somador.somar());

// const x = somador.getArray();
// const ordenador3 = new Ordenador(x);
// console.log(ordenador3.ordenar());

// Exercício 13
// import { Aluno } from "../exercicio-13/Aluno.js";

// const aluno = new Aluno(6);
// console.log(aluno.getStatus());

// aluno.adicionarNota(7);
// console.log(aluno.getMedia());
// console.log(aluno.getStatus());

// Exercício 14
// import { ConversorHoras } from "../exercicio-14/ConversorHoras.js";

// const conversorHoras = new ConversorHoras(7023);
// console.log(conversorHoras.getHoras());

// Exercício 15
// import { Menu } from './../exercicio-4/Menu.js';
// import { Calculadora } from './../exercicio-15/Calculadora.js';

// const menu = new Menu();
// const calculadora = new Calculadora();

// menu.questoes();
// console.log(calculadora.calcular(
//     menu.getNumero1(),
//     menu.getNumero2(),
//     menu.getOperador()));

// Exercício 16
// import { Livro } from './../exercicio-16/Livro.js';
// import { Pessoa } from './../exercicio-16/Pessoa.js';

// const pessoa = new Pessoa('atypus');
// const livro = new Livro('Bottomless', 'Sera');

// console.log(pessoa.pegarEmprestado(livro));