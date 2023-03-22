package org.example.exercicio16;

import java.util.ArrayList;

public class Pessoa {
    private final String nome;
    private final ArrayList<Emprestimo> emprestimos;

    public Pessoa(String nome) {
        this.nome = nome;
        this.emprestimos = new ArrayList<>();
    }

    public void pegarEmprestado(Livro livro) {
        if(livro.isDisponivel()) {
            Emprestimo emprestimo = new Emprestimo(livro, this);
            livro.setDisponivel(false);
            this.emprestimos.add(emprestimo);
            System.out.println("O livro '" + livro.getTitulo() + "' foi emprestado");
        } else {
            System.out.println("O livro '" + livro.getTitulo() + "' não está disponível");
        }
    }

    public void devolverLivro(Livro livro) {
        Emprestimo emprestimo = buscarEmprestimo(livro);
        if(emprestimo != null) {
            this.emprestimos.remove(emprestimo);
            livro.setDisponivel(true);
            System.out.println("O livro '" + livro.getTitulo() + "' foi devolvido");
        } else {
            System.out.println("Você não está com esse livro");
        }
    }

    private Emprestimo buscarEmprestimo(Livro livro) {
        for(Emprestimo emprestimo : this.emprestimos) {
            if(emprestimo.getLivro().equals(livro))
                return emprestimo;
        }
        return null;
    }
}
