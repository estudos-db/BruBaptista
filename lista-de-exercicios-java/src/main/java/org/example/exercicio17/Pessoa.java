package org.example.exercicio17;

public class Pessoa {
    private final String nome;
    private int idade;
    private Pessoa pai;
    private Pessoa mae;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        setIdade(idade);
    }

    public Pessoa(String nome, int idade, Pessoa pai, Pessoa mae) {
        this.nome = nome;
        setIdade(idade);
        setPai(pai);
        setMae(mae);
    }

    public void setIdade(int idade) {
        if(idade < 0)
            throw new IllegalArgumentException("Idade não pode ser negativa");
        else if(idade > 150)
            throw new IllegalArgumentException("Idade máxima ultrapassada");
        this.idade = idade;
    }

    public void setPai(Pessoa pai) {
        if (pai == null || pai.idade > this.idade)
            this.pai = pai;
        else
            throw new IllegalArgumentException("O pai deve ser mais velho que a pessoa.");
    }

    public void setMae(Pessoa mae) {
        if (mae == null || mae.idade > this.idade)
            this.mae = mae;
        else
            throw new IllegalArgumentException("A mãe deve ser mais velha que a pessoa.");
    }

    public String imprimePais() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: ").append(this.nome).append(", idade: ").append(this.idade).append("\nPai: ");
        if(this.pai != null)
            sb.append(this.pai.nome);
        else
            sb.append("Desconhecido");
        sb.append(", mãe: ");
        if(this.mae != null)
            sb.append(this.mae.nome);
        else
            sb.append("Desconhecida");
        return sb.toString();
    }

    public String imprimeArvore() {
        return imprimeArvore(0, new StringBuilder()).toString();
    }
    private StringBuilder imprimeArvore(int ancestralidade, StringBuilder sb) {
        sb.append("\nAncestralidade: ").append(ancestralidade);
        sb.append("\n").append(imprimePais());
        if(this.pai != null) {
            sb.append(this.pai.imprimeArvore(ancestralidade +1, new StringBuilder()));
        }
        if(this.mae != null) {
            sb.append(this.mae.imprimeArvore(ancestralidade +1, new StringBuilder()));
        }
        return sb;
    }
}