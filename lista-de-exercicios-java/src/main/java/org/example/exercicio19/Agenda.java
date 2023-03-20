package org.example.exercicio19;

import java.util.ArrayList;

public class Agenda {
    private ArrayList<Contato> contatos;

    public Agenda() {
        this.contatos = new ArrayList<Contato>();
    }

    public void adicionarContato(Contato novoContato) {
        contatos.add(novoContato);
        System.out.println("Novo contato adicionado");
    }

    public void removerContato(Contato contato) {
        if(contatos.size() != 0) {
            if(contatos.contains(contato)) {
                contatos.remove(contato);
                System.out.println("O contato foi removido");
            } else
                System.out.println("Esse contato não está na agenda");

        } else
            System.out.println("A agenda está vazia");
    }

    public void listarContatos() {
        if(contatos.size() != 0) {
            for (Contato contato : contatos)
                System.out.println(contato.getContato());
        } else
            System.out.println("A agenda está vazia");
    }
}
