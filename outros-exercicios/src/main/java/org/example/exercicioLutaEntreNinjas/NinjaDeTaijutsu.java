package org.example.exercicioLutaEntreNinjas;

public class NinjaDeTaijutsu extends Personagem implements Ninja {
    public NinjaDeTaijutsu(String nome) {
        super(nome);
    }

    @Override
    public boolean desviar() {
        if(this.getChakra() <= 5) {
            System.out.println("O ninja não pode desviar por falta de chakra");
            return false;
        }
        else {
            consumirChakra(5);
            double conseguirDesviar = Math.floor(Math.random() * 2);
            if (conseguirDesviar == 1) {
                StringBuilder sb1 = new StringBuilder();
                sb1.append("O ninja ")
                        .append(this.getNome())
                        .append(" está desviando de um ataque usando sua habilidade em Taijutsu");
                System.out.println(sb1);
                return true;
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("O ninja ")
                        .append(this.getNome())
                        .append(" não conseguiu desviar");
                System.out.println(sb2);
                return false;
            }
        }
    }
}