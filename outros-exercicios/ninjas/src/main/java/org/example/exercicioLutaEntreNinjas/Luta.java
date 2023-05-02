package org.example.exercicioLutaEntreNinjas;

public class Luta {

    private Ninja ninjaUm;
    private Ninja ninjaDois;
    private Ninja ninjaInicial;

    public Luta(Ninja ninjaUm, Ninja ninjaDois) {
        this.ninjaUm = ninjaUm;
        this.ninjaDois = ninjaDois;
    }

    public String ordenarNinjas() {
        double resultado = Math.floor(Math.random() * 2);
        if (resultado == 1)
            ninjaInicial = ninjaUm;
        else
            ninjaInicial = ninjaDois;
        return "O primeiro movimento é do " + ninjaInicial.getNome();
    }

    public String batalha(Ninja atacante, Jutsu jutsu, Ninja defensor, boolean tentouDesviar) {
        try {
            autenticarNinjaTemJutsu(atacante, jutsu);
        } catch (Exception e) {
            return e.getMessage();
        }

        atacante.usarJutsu(jutsu);
        StringBuilder sb = new StringBuilder();
        sb.append("O ninja ")
                .append(atacante.getNome())
                .append(" usou ")
                .append(jutsu.getNome());

        if (tentouDesviar) {
            if (defensor.desviar()) {
                sb.append("\nO ninja ")
                        .append(defensor.getNome())
                        .append(" desviou");
                autenticarStatus(sb, atacante);
                autenticarStatus(sb, defensor);
                return sb.toString();
            }
            sb.append("\nO ninja ")
                    .append(defensor.getNome())
                    .append(" não conseguiu desviar");
        }

        defensor.consumirVida(jutsu.getDano());
        sb.append("\nO ninja ")
                .append(defensor.getNome())
                .append(" levou ")
                .append(jutsu.getDano())
                .append(" de dano");

        autenticarStatus(sb, atacante);
        autenticarStatus(sb, defensor);
        return sb.toString();
    }

    private void autenticarStatus(StringBuilder sb, Ninja ninja) {
        if(ninja.getChakra() == 0)
            sb.append("\nO ninja ")
                    .append(ninja.getNome())
                    .append(" não tem mais chakra e não pode mais lutar");
        if(ninja.getVida() == 0)
            sb.append("\nO ninja ")
                    .append(ninja.getNome())
                    .append(" não tem mais vida e não pode mais lutar");
    }

    private void autenticarNinjaTemJutsu(Ninja atacante, Jutsu jutsu) {
        if(!atacante.temJutsu(jutsu.getNome())) {
            StringBuilder sb = new StringBuilder();
            sb.append("O ninja ")
                    .append(atacante.getNome())
                    .append(" não possui o jutsu ")
                    .append(jutsu.getNome());
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public Ninja getNinjaInicial() {
        return ninjaInicial;
    }
}