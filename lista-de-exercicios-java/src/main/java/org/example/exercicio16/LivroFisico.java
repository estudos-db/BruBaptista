package org.example.exercicio16;

public class LivroFisico extends Livro implements LivroCadastrado {
    private boolean disponivel = true;
    private final boolean fisico = true;
    private String prateleira;

    public LivroFisico(String titulo, String autor, String prateleira) {
        super(titulo, autor);
        this.prateleira = prateleira;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}
