package org.example.exercicio19;

import java.util.ArrayList;

public class Agenda {
    private final ArrayList<Contato> contatos;

    public Agenda() {
        this.contatos = new ArrayList<>();
    }

    public void adicionarContato(Contato novoContato) {
        if(contatos.contains(novoContato))
            throw new IllegalArgumentException("O contato já está na agenda");
        contatos.add(novoContato);
    }

    public void removerContato(Contato contato) {
        if(contatos.contains(contato))
            contatos.remove(contato);
        else
            throw new IllegalArgumentException("Esse contato não está na agenda");
    }

    public String buscarContatoPorNome(String nome) {
        for(Contato contato : contatos)
            if(contato.getNome().equals(nome))
                return contato.info();
        throw new IllegalArgumentException("Esse contato não está na agenda");
    }

    public String listarTodosContatos() {
        if(contatos.size() == 0)
            throw new IllegalArgumentException("A agenda está vazia");

        StringBuilder todosContatos = new StringBuilder();
        for(Contato contato : contatos)
            todosContatos.append(contato.info()).append("\n");

        return todosContatos.toString();
    }

    public void editarNome(Contato contato, String novoNome) {
        contato.setNome(novoNome);
    }

    public void editarDdd(Contato contato, int novoDdd) {
        contato.setDdd(novoDdd);
    }

    public void editarNumero(Contato contato, int novoNumero) {
        contato.setTelefone(novoNumero);
    }

    public void editarEmail(Contato contato, String novoEmail) {
        contato.setEmail(novoEmail);
    }

    public void editarEndereco(Contato contato, int cep, String rua, int numero, String bairro,
                               String cidade, String estado) {
        contato.setEndereco(cep, rua, numero, bairro, cidade, estado);
    }

    public ArrayList<Contato> getContatos() {
        return contatos;
    }
}
