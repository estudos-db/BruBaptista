package org.example.exercicio16;

import java.time.LocalDateTime;

public class Emprestimo {
    private final Livro livro;
    private final Pessoa pessoa;
    private final LocalDateTime dataEmprestimo;
    private LocalDateTime dataDevolucao;

    public Emprestimo(Livro livro, Pessoa pessoa) {
        this.livro = livro;
        this.pessoa = pessoa;
        this.dataEmprestimo = LocalDateTime.now();
    }

    public Livro getLivro() {
        return livro;
    }
}
