package org.example.exercicioLutaEntreNinjas;

public class NinjaDeNinjutsu extends Personagem implements Ninja {
    public NinjaDeNinjutsu(String nome) {
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
                .append(" está desviando de um ataque usando sua habilidade em Ninjutsu");
        return sb.toString();
    }
}
