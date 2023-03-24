package org.example.exercicio16;

public class LivroFisico extends Livro implements LivroCadastrado {
    private boolean disponivel = true;
    private final boolean fisico = true;

    public LivroFisico(String titulo, String autor) {
        super(titulo, autor);
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public boolean isFisico() {
        return fisico;
    }
}
