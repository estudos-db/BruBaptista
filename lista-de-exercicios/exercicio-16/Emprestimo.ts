import { Pessoa } from './Pessoa.js';
import { Livro } from './Livro.js';

export class Emprestimo {
    private pessoa: Pessoa;
    private livro: Livro;
    
    public constructor (
        pessoa: Pessoa,
        livro: Livro) {
        this.pessoa = pessoa;
        this.livro = livro;
    }

    getLivro(): Livro {
        return this.livro;
    }
}