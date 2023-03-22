package org.example.exercicio19;

import java.util.ArrayList;

public class Agenda {
    private final ArrayList<Contato> contatos;

    public Agenda() {
        this.contatos = new ArrayList<>();
    }

    public void adicionarContato(Contato novoContato) {
        contatos.add(novoContato);
        System.out.println("Novo contato adicionado");
    }

    public void removerContato(Contato contato) {
        if(contatos.contains(contato)) {
            contatos.remove(contato);
            System.out.println("O contato foi removido");
        } else
            System.out.println("Esse contato não está na agenda");
    }

    public void listarTodosContatos() {
        if(contatos.size() > 0) {
            for (Contato contato : contatos)
                System.out.println(contato.getContato());
        } else
            System.out.println("A agenda está vazia");
    }

    public void listarContatosPorCategoria(String categoria) {
        boolean encontrou = false;
        for (Contato contato : contatos)
            if(contato.getCategoria().equals(categoria)) {
                System.out.println(contato.getContato());
                encontrou = true;
            }
        if(!encontrou)
            System.out.println("Não existem contatos nessa categoria");
    }

    public void editarNome(Contato contato, String novoNome) {
        contato.setNome(novoNome);
        System.out.println("O nome do contato foi atualizado para: " + novoNome);
    }

    public void editarNumero(Contato contato, int novoNumero) {
        contato.setNumero(novoNumero);
        System.out.println("O numero do contato foi atualizado para: " + novoNumero);
    }

    public void editarDdd(Contato contato, int novoDdd) {
        contato.setDdd(novoDdd);
        System.out.println("O DDD do contato foi atualizado para: " + novoDdd);
    }

    public void editarCategoria(Contato contato, String novaCategoria) {
        contato.setCategoria(novaCategoria);
        System.out.println("A categoria do contato foi atualizada para: " + novaCategoria);
    }
}
