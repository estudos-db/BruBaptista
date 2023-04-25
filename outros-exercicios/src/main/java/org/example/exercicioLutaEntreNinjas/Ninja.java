package org.example.exercicioLutaEntreNinjas;

public interface Ninja {
    String getNome();
    int getChakra();
    void setChakra(int chakra);

    public default String usarJutsu(Jutsu jutsu) {
        if(this.getChakra() <= jutsu.getConsumoDeChakra())
            return "O ninja está incapacitado por falta de chakra";

        consumirChakra(jutsu.getConsumoDeChakra());
        StringBuilder sb = new StringBuilder();
        sb.append("O ninja ")
                .append(this.getNome())
                .append(" está atacando usando o ")
                .append(jutsu.getNome());
        return sb.toString();
    }
    public default String desviar() {
        if(this.getChakra() <= 5)
            return "O ninja está incapacitado por falta de chakra";

        consumirChakra(5);
        return "O ninja desviou";
    };

    public default void consumirChakra(int consumo) {
        int chackraAtual = this.getChakra() - consumo;
        this.setChakra(chackraAtual);
    }
}
