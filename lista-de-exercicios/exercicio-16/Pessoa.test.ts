import { jest } from '@jest/globals';
import { Livro } from './Livro';
import { Pessoa } from './Pessoa';

const pessoa = new Pessoa('atypus');
const livro = new Livro('Bottomless', 'Sera');

describe('Classe Pessoa', () => {
    test('Deve fazer um emprestimo do livro', () => {
        expect(pessoa.pegarEmprestado(livro)).toBe("O Bottomless foi emprestado.")
    })
    test('Deve devolver o livro', () => {
        
    })
})