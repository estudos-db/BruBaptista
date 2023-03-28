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

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty())
            throw new IllegalArgumentException("Nome inválido");
        this.nome = nome;
        System.out.println("O nome foi atualizado para: " + this.nome);
    }

    public String getNome() {
        return nome;
    }

    public void setNumero(int numero) {
        if(numero < 10000000 || numero > 999999999)
            throw new IllegalArgumentException("O número deve ter 8 ou 9 dígitos");
        this.numero = numero;
        System.out.println("O número foi atualizado para: " + this.numero);
    }

    public int getNumero() {
        return numero;
    }

    public void setDdd(int ddd) {
        if(ddd < 10 || ddd > 99)
            throw new IllegalArgumentException("O DDD deve ter 2 dígitos");
        this.ddd = ddd;
        System.out.println("O DDD foi atualizado para: " + this.ddd);
    }

    public int getDdd() {
        return ddd;
    }

    public void setCategoria(Categorias categoria) {
        this.categoria = categoria;
        System.out.println("A categoria foi atualizada para: " + this.categoria);
    }

    public String getCategoria() {
        if(categoria != null)
            return categoria.toString();
        else
            return "Nenhuma";
    }
}
