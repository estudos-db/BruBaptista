package org.example.exercicio19;

public class TesteAgenda {
    public static void main(String[] args) {
        Contato rafflesia = new Contato("Rafflesia", 25, 999991111);
        Contato sera = new Contato("Sera", 12, 973157318);
        System.out.println(rafflesia.getContato());
        System.out.println(sera.getContato());
        System.out.println();

        Agenda agenda = new Agenda();
        agenda.listarTodosContatos();
        agenda.adicionarContato(rafflesia);
        rafflesia.getContato();
        rafflesia.setNome("a");
        rafflesia.setDdd(20);
        rafflesia.setNumero(111119999);
        rafflesia.setCategoria(Categorias.TRABALHO);
        System.out.println(rafflesia.getContato());

        System.out.println();
        agenda.adicionarContato(sera);
        System.out.println();
        agenda.listarTodosContatos();
        System.out.println();
        agenda.listarContatosPorCategoria(Categorias.TRABALHO);
        agenda.listarContatosPorCategoria(Categorias.FAMILIA);

    }
}
