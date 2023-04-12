package org.example.exercicio16;

public class LivroDigital extends Livro implements LivroCadastrado {
    private boolean disponivel = true;
    private final boolean fisico = false;
    private String link;

    public LivroDigital(String titulo, String autor, String link) {
        super(titulo, autor);
        this.link = link;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}
