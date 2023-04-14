package org.example.exercicio16;

import java.util.ArrayList;
import java.util.List;

public class Pessoa {
    private final String nome;
    private final int idade;
    private List<LivroCadastrado> livrosLidos;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
        this.livrosLidos = new ArrayList<>();
    }

    public void adicionarLivroLido(LivroCadastrado livro) {
        if(livrosLidos.contains(livro))
            throw new IllegalArgumentException("Este livro já foi adicionado na lista");
        livrosLidos.add(livro);
    }

    public void removerLivroLido(LivroCadastrado livro) {
        if(!livrosLidos.remove(livro))
            throw new IllegalArgumentException("Livro não encontrado na lista de livros lidos");
        livrosLidos.remove(livro);
    }

    public String getNome() {
        return nome;
    }

    public List<LivroCadastrado> getLivrosLidos() {
        return livrosLidos;
    }
}