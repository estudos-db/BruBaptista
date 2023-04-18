package org.example.exercicio19;

public class Endereco {
    private int cep;
    private String rua;
    private int numero;
    private String bairro;
    private String cidade;
    private String estado;

    public Endereco(int cep, String rua, int numero, String bairro,
                    String cidade, String estado) {
        this.cep = cep;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.setEstado(estado);
    }

    public String info() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.cep)
                .append("\n")
                .append(this.rua)
                .append(", ")
                .append(this.numero)
                .append(", ")
                .append("\n")
                .append(this.bairro)
                .append("\n")
                .append(this.cidade)
                .append(", ")
                .append(this.estado);
        return sb.toString();
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setEstado(String estado) {
        if(estado.length() > 2)
            throw new IllegalArgumentException("Estado inválido");
        this.estado = estado.toUpperCase();
    }

    public String getEstado() {
        return estado;
    }
}
