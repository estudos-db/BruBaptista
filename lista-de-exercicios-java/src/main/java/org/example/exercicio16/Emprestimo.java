package org.example.exercicio16;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Emprestimo {
    private Pessoa pessoa;
    private List<LivroCadastrado> livrosEmprestados;

    public Emprestimo(Pessoa pessoa) {
        this.pessoa = pessoa;
        this.livrosEmprestados = new ArrayList<>();
    }

    public String emprestarLivro(LivroCadastrado livro) {
        validarEmprestimo(livro);
        livrosEmprestados.add(livro);
        pessoa.adicionarLivroLido(livro);
        livro.setDisponivel(false);
        LocalDate dataDevolucao = dataDevolucao();

        StringBuilder sb = new StringBuilder();
        sb.append("Livro \"").append(livro.getTitulo()).append("\" emprestado com sucesso para ")
                        .append(pessoa.getNome()).append("\nData de devolução: ").append(dataDevolucao);
        return sb.toString();
    }

    private LocalDate dataDevolucao() {
        return LocalDate.now().plusWeeks(1);
    }

    private void validarEmprestimo(LivroCadastrado livro) {
        if(livrosEmprestados.size() >= 2)
            throw new IllegalArgumentException("Você já tem dois livros emprestados, "
                    + "devolva algum antes de pegar o próximo");
        if(!livro.isDisponivel())
            throw new IllegalArgumentException("Este livro não está disponível no momento");
    }

    public String devolverLivro(LivroCadastrado livro) {
        if(!livrosEmprestados.remove(livro)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Livro \"").append(livro.getTitulo())
                    .append("\" não foi encontrado na lista de empréstimos de ").append(pessoa.getNome());
            throw new IllegalArgumentException(sb.toString());
        }
        livrosEmprestados.remove(livro);
        livro.setDisponivel(true);
        StringBuilder sb = new StringBuilder();
        sb.append("Livro \"").append(livro.getTitulo()).append("\" devolvido com sucesso por ")
                .append(pessoa.getNome());
        return sb.toString();
    }

    public List<LivroCadastrado> getLivrosEmprestados() {
        return livrosEmprestados;
    }
}
