package org.example.exercicio16;

import java.time.LocalDateTime;

public class Emprestimo {
    private final LivroCadastrado livro;
    private final Pessoa pessoa;
    private final LocalDateTime dataEmprestimo;
    private LocalDateTime dataDevolucao;

    public Emprestimo(LivroCadastrado livro, PessoaCadastrada pessoa) {
        this.livro = livro;
        this.pessoa = pessoa;
        this.dataEmprestimo = LocalDateTime.now();
    }

    public LivroCadastrado getLivro() {
        return livro;
    }
}
