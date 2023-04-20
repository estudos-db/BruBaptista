package org.example.exercicioNaruto;

public class NinjaDeTaijutsu extends Personagem implements Ninja {
    private int energia;

    public NinjaDeTaijutsu(String nome, int idade, String aldeia, int energia) {
        super(nome, idade, aldeia, 0);
        this.setEnergia(energia);
    }

    @Override
    public String usarJutsu() {
        StringBuilder sb = new StringBuilder();
        sb.append("O ninja ")
                .append(this.getNome())
                .append(" está usando um golpe de Taijutsu");
        return sb.toString();
    }

    @Override
    public String desviar() {
        StringBuilder sb = new StringBuilder();
        sb.append("O ninja ")
                .append(this.getNome())
                .append(" está desviando de um ataque usando sua habilidade em Taijutsu");
        return sb.toString();
    }

    @Override
    public String aumentarChakra(int valor) {
        return "Um ninja de Taijutsu não pode aumentar seu chakra";
    }

    private void setEnergia(int energia) {
        if(energia > 0 && energia <= 10)
            this.energia = energia;
        else
            throw new IllegalArgumentException("Um ninja iniciante não pode ter essa quantidade de energia");
    }
}