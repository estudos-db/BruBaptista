package org.example.exercicioNaruto;

public class NinjaDeGenjutsu extends Personagem implements Ninja {
    public NinjaDeGenjutsu(String nome, int idade, String aldeia, int chakra) {
        super(nome, idade, aldeia, chakra);
    }

    @Override
    public String usarJutsu() {
        StringBuilder sb = new StringBuilder();
        sb.append("O ninja ")
                .append(this.getNome())
                .append(" está usando um jutsu de Genjutsu");
        return sb.toString();
    }

    @Override
    public String desviar() {
        StringBuilder sb = new StringBuilder();
        sb.append("O ninja ")
                .append(this.getNome())
                .append(" está desviando de um ataque usando sua habilidade em Genjutsu");
        return sb.toString();
    }
}