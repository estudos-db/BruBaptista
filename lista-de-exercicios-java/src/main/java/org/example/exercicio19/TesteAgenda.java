package org.example.exercicio19;

public class TesteAgenda {
    public static void main(String[] args) {
        Contato rafflesia = new Contato("Rafflesia", 25, 999991111);
        Contato sera = new Contato("Sera", 12, 973157318);
        //System.out.println(rafflesia.getContato());
        System.out.println(sera.getContato());

        Agenda agenda = new Agenda();
        agenda.listarContatos();
        agenda.adicionarContato(rafflesia);
        agenda.listarContatos();
        agenda.removerContato(sera);
        agenda.removerContato(rafflesia);
        agenda.listarContatos();
    }
}
