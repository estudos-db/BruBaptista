package org.example.exercicio16;

import java.util.ArrayList;

public class Biblioteca {
    private final ArrayList<Pessoa> usuarios;
    private final ArrayList<Livro> livros;

    public Biblioteca() {
        this.livros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    public void cadastrarUsuario(Pessoa pessoa, String nomeUsuario) {
        if (!nomeUsuario.matches("[a-zA-Z0-9]+")) {
            System.out.println("O nome de usuário não é válido. Use apenas letras e números.");
            return;
        }
        PessoaCadastrada pessoaCadastrada = new PessoaCadastrada(nomeUsuario + "User");
        usuarios.add(pessoaCadastrada);
        System.out.println("O usuário " + pessoa.getNome() +
                " foi cadastrado na biblioteca com o nome de usuário: " + nomeUsuario + "User");
    }

    public PessoaCadastrada buscarUsuario(Pessoa pessoa) {
        for (Pessoa p : usuarios) {
            if (p instanceof PessoaCadastrada && p.getNome().equals(pessoa.getNome() + "User")) {
                System.out.println("Usuário " + p.getNome() + " encontrado");
                return (PessoaCadastrada) p;
            }
        }
        System.out.println("Usuário não encontrado.");
        return null;
    }

    public void adicionarLivro(Livro livro, boolean fisico) {
        if(fisico) {
            LivroFisico livroFisico = new LivroFisico(livro.getTitulo(), livro.getAutor());
            livros.add(livroFisico);
            System.out.println("O livro " + livro.getTitulo() + " foi adicionado na biblioteca");
        } else {
            LivroDigital livroDigital = new LivroDigital(livro.getTitulo(), livro.getAutor());
            livros.add(livroDigital);
            System.out.println("O livro " + livro.getTitulo() + " foi adicionado na biblioteca em formato digital");
        }
    }

    public void verificarDisponibilidade(Livro livro) {
        LivroCadastrado livroCadastrado = buscarLivro(livro);
        if(livroCadastrado != null) {
            if(livroCadastrado.isDisponivel() && livroCadastrado.isFisico())
                System.out.println("O livro " + livro.getTitulo() + " está disponível em formato físico");
            else if(livroCadastrado.isDisponivel() && !livroCadastrado.isFisico())
                System.out.println("O livro " + livro.getTitulo() + " está disponível em formato digital");
            else
                System.out.println("O livro " + livro.getTitulo() + " não está disponível");
        } else {
            System.out.println("O livro " + livro.getTitulo() + " não foi encontrado na biblioteca");
        }
    }

    private LivroCadastrado buscarLivro(Livro livro) {
        for (Livro l : livros) {
            if (l instanceof LivroCadastrado && l.getTitulo().equals(livro.getTitulo()) && l.getAutor().equals(livro.getAutor())) {
                return (LivroCadastrado) l;
            }
        }
        return null;
    }
}