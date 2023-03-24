package org.example.exercicio16;

import java.util.ArrayList;

public class PessoaCadastrada extends Pessoa {
    private final int id;
    private final ArrayList<Emprestimo> emprestimos;

    public PessoaCadastrada(String nome) {
        super(nome);
        this.id = hashCode();
        this.emprestimos = new ArrayList<>();
    }
    public void pegarEmprestado(LivroCadastrado livro) {
        if(livro.isDisponivel()) {
            Emprestimo emprestimo = new Emprestimo(livro, this);
            livro.setDisponivel(false);
            this.emprestimos.add(emprestimo);
            System.out.println("O livro '" + livro.getTitulo() + "' foi emprestado");
        } else {
            System.out.println("O livro '" + livro.getTitulo() + "' não está disponível");
        }
    }

    public void devolverLivro(LivroCadastrado livro) {
        Emprestimo emprestimo = buscarEmprestimo(livro);
        if(emprestimo != null) {
            this.emprestimos.remove(emprestimo);
            livro.setDisponivel(true);
            System.out.println("O livro '" + livro.getTitulo() + "' foi devolvido");
        } else {
            System.out.println("Você não está com esse livro");
        }
    }

    private Emprestimo buscarEmprestimo(LivroCadastrado livro) {
        for(Emprestimo emprestimo : this.emprestimos) {
            if(emprestimo.getLivro().equals(livro))
                return emprestimo;
        }
        return null;
    }
}
