package org.example.exercicioLutaEntreNinjas;

public interface Ninja {
    String getNome();
    int getChakra();
    int getVida();
    void consumirVida(int consumo);
    boolean temJutsu(String nomeJutsu);
    public boolean desviar();
    public String usarJutsu(Jutsu jutsu);
}