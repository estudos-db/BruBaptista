package org.example.exercicioLutaEntreNinjas;

public class NinjaDeGenjutsu extends Personagem implements Ninja {
    public NinjaDeGenjutsu(String nome) {
        super(nome);
    }

    @Override
    public String desviar() {
        if(this.getChakra() <= 5)
            return "O ninja está incapacitado por falta de chakra";
        consumirChakra(5);

        StringBuilder sb = new StringBuilder();
        sb.append("O ninja ")
                .append(this.getNome())
                .append(" está desviando de um ataque usando sua habilidade em Genjutsu");
        return sb.toString();
    }
}
