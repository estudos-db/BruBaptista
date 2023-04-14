package org.example.exercicio19;

public class Contato {
    private String nome;
    private int ddd;
    private int telefone;
    private String email;
    private Endereco endereco;

    public Contato(String nome, int ddd, int telefone, String email, Endereco endereco) {
        this.setNome(nome);
        this.setDdd(ddd);
        this.setTelefone(telefone);
        this.setEmail(email);
        this.endereco = endereco;
    }

    public String info() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: ")
                .append(this.nome)
                .append("\nTelefone: (")
                .append(this.ddd)
                .append(")")
                .append(this.telefone)
                .append("\nE-mail: ")
                .append(this.email)
                .append("\nCEP: ")
                .append(endereco.info());
        return sb.toString();
    }

    public void setNome(String nome) {
        if(nome.isEmpty())
            throw new IllegalArgumentException("Nome inválido");
        this.nome = nome;
    }

    public void setDdd(int ddd) {
        if(ddd < 10 || ddd > 99)
            throw new IllegalArgumentException("O DDD deve ter 2 dígitos");
        this.ddd = ddd;
    }

    public void setTelefone(int telefone) {
        if(telefone < 10000000 || telefone > 999999999)
            throw new IllegalArgumentException("O número deve ter 8 ou 9 dígitos");
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        if(!email.contains("@") || email.contains(" ")) {
            throw new IllegalArgumentException("Email inválido");
        }
        this.email = email;
    }

    public void setEndereco(int cep, String rua, int numero, String bairro,
                               String cidade, String estado) {
        endereco.setCep(cep);
        endereco.setRua(rua);
        endereco.setNumero(numero);
        endereco.setBairro(bairro);
        endereco.setCidade(cidade);
        endereco.setEstado(estado);
    }

    public String getNome() {
        return nome;
    }

    public int getDdd() {
        return ddd;
    }

    public int getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }
}
