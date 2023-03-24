package org.example.exercicio19;

public class Contato {
    private String nome;
    private int numero;
    private int ddd;
    private Categorias categoria;

    public Contato(String nome, int ddd, int numero) {
        this.setNome(nome);
        this.setDdd(ddd);
        this.setNumero(numero);
    }

    public Contato(String nome, int ddd, int numero, Categorias categoria) {
        this.setNome(nome);
        this.setDdd(ddd);
        this.setNumero(numero);
        this.setCategoria(categoria);
    }

    public String getContato() {
        return "Nome: " + this.nome + "\nTelefone: (" + this.ddd + ")"
                + this.numero + "\nCategoria: " + getCategoria();
    }

    public Categorias getCategoria() {
        //if(categoria != null)
            return this.categoria;
        //else
            //return "Não pertence a uma categoria";
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty())
            throw new IllegalArgumentException("Nome inválido");
        this.nome = nome;
        System.out.println("O nome foi atualizado para: " + this.nome);
    }

    public void setNumero(int numero) {
        if(numero < 10000000 || numero > 999999999)
            throw new IllegalArgumentException("O número deve ter 8 ou 9 dígitos");
        this.numero = numero;
        System.out.println("O número foi atualizado para: " + this.numero);
    }

    public void setDdd(int ddd) {
        if(ddd < 10 || ddd > 99)
            throw new IllegalArgumentException("O DDD deve ter 2 dígitos");
        this.ddd = ddd;
        System.out.println("O DDD foi atualizado para: " + this.ddd);
    }

    public void setCategoria(Categorias categoria) {
        this.categoria = categoria;
        System.out.println("A categoria foi atualizada para: " + this.categoria);
    }

    private void validarCategoria(String categoria) {
        if (categoria == null || categoria.trim().isEmpty())
            throw new IllegalArgumentException("A categoria não pode ser vazia.");
        if (categoria.contains(" "))
            throw new IllegalArgumentException("A categoria não pode conter espaços.");
        if (!Character.isUpperCase(categoria.charAt(0)))
            throw new IllegalArgumentException("A categoria deve começar com uma letra maiúscula.");
    }
}
