import { Emprestimo } from "./Emprestimo.js";
import { Livro } from "./Livro.js";

export class Pessoa {
    private nome: string;
    private emprestimos: Array<Emprestimo>;

    public constructor (nome: string) {
        this.nome = nome;
        this.emprestimos = [];
    }

    public pegarEmprestado(livro: Livro) {
        this.emprestimos.push(new Emprestimo(this, livro));
    }

    public devolver(livro: Livro) {
        let emprestimoAtual: Emprestimo;
        const buffer: Array<Emprestimo>;
        do {
            let livroAtual: Livro;
            emprestimoAtual = this.emprestimos.pop();
            livroAtual = emprestimoAtual.getLivro();
            if () {
                buffer.push(emprestimoAtual);
            }
        }
    }
}