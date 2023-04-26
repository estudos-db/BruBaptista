package org.example.exercicioLutaEntreNinjas;

public interface Ninja {
    String getNome();
    int getChakra();
    void setChakra(int chakra);
    int getVida();
    void setVida(int vida);
    boolean temJutsu(String nomeJutsu);
    public boolean desviar();

    public default String usarJutsu(Jutsu jutsu) {
        if(this.getChakra() < jutsu.getConsumoDeChakra()) {
            this.setChakra(0);
            return "O ninja está incapacitado por falta de chakra";
        }

        consumirChakra(jutsu.getConsumoDeChakra());
        StringBuilder sb = new StringBuilder();
        sb.append("O ninja ")
                .append(this.getNome())
                .append(" está atacando usando o ")
                .append(jutsu.getNome());
        return sb.toString();
    }

    public default void consumirChakra(int consumo) {
        int chackraAtual = this.getChakra() - consumo;
        this.setChakra(chackraAtual);
    }
}
