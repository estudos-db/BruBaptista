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
        const buffer = new Array<Emprestimo>;
        while (this.emprestimos.length > 0) {
            let livroAtual: Livro;
            emprestimoAtual = this.emprestimos.pop();
            livroAtual = emprestimoAtual.getLivro();
            if (livroAtual.getAutor() == livro.getAutor() && livroAtual.getTitulo() == livro.getTitulo()) {
                break;
            } else {
                buffer.push(emprestimoAtual);
            }
        }
        while (buffer.length > 0)
            this.emprestimos.push(buffer.pop());
    }
}