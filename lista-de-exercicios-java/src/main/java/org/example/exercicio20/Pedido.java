package org.example.exercicio20;

import java.util.ArrayList;

public class Pedido {
    private ArrayList<Item> listaDeItens = new ArrayList<>();
    private double valorTotalDoPedido = 0;

    public void calculaValorTotal() {
        for(Item item : listaDeItens)
            valorTotalDoPedido += item.defineValorTotal();
    }

    public boolean adicionaItemNaLista(Produto produto, int quantidade) throws IllegalArgumentException {
        for(Item item : listaDeItens)
            if(item.getProduto().getNome().equals(produto.getNome())) {
                item.setQuantidade(item.getQuantidade() + quantidade);
                return true;
            }
        Item item = new Item(produto, quantidade);
        listaDeItens.add(item);
        return true;
    }

    public boolean removeItemDaLista(Produto produto) throws IllegalArgumentException {
        for(Item item : listaDeItens)
            if(item.getProduto().getNome().equals(produto.getNome())) {
                listaDeItens.remove(item);
                return true;
            }
        return false;
    }

    public void imprimePedido() {
        if(listaDeItens.size() == 0) {
            System.out.println("Lista vazia\n");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Pedido:\n");
        for(Item item : listaDeItens)
            sb.append(item.getQuantidade())
                    .append("x ")
                    .append(item.getProduto().getNome())
                    .append(", por: ")
                    .append(item.defineValorTotal())
                    .append("\n");
        sb.append("Valor total: ")
                .append(getValorTotalDoPedido())
                .append("\n");
        System.out.println(sb);
    }

    public void imprimeValorTotal() {
        StringBuilder sb = new StringBuilder();
        sb.append("O valor total é: ")
                    .append(getValorTotalDoPedido())
                    .append("\n");
        System.out.println(sb);
    }

    public void limparCarrinho() {
        listaDeItens = new ArrayList<>();
    }

    public ArrayList<Item> getListaDeItens() {
        return listaDeItens;
    }

    public double getValorTotalDoPedido() {
        return valorTotalDoPedido;
    }

    public double calculaTroco(double valorPago) {
        if(valorPago < getValorTotalDoPedido())
            throw new IllegalArgumentException("Valor pago insuficiente.");
        return valorPago - getValorTotalDoPedido();
    }

    public CalculoTroco calculaQuantidadeDeNotas(double valorTroco) {
        int[] notas = {100, 50, 20, 10, 5, 2};
        int[] quantidadeDeNotas = new int[notas.length];
        int resto = (int) (valorTroco * 100);
        for(int i = 0; i < notas.length; i++)
            if(resto >= notas[i] * 100) {
                quantidadeDeNotas[i] = resto / (notas[i] * 100);
                resto %= notas[i] * 100;
            }
        return new CalculoTroco(quantidadeDeNotas, resto);
    }

    public CalculoTroco calculaQuantidadeDeMoedas(CalculoTroco calculoTroco) {
        double[] moedas = {1, 0.5, 0.25, 0.1, 0.05};
        int[] quantidadeDeMoedas = new int[moedas.length];
        int resto = calculoTroco.getResto();

        if(resto == 0)
            return new CalculoTroco(new int[quantidadeDeMoedas.length], new int[quantidadeDeMoedas.length]);

        for(int i = 0; i < moedas.length; i++)
            if(resto >= moedas[i] * 100) {
                quantidadeDeMoedas[i] = (int) (resto / (moedas[i] * 100));
                resto %= (moedas[i] * 100);
            }
        return new CalculoTroco(calculoTroco.getQuantidadeDeNotas(), quantidadeDeMoedas);
    }

    public String geraTrocoFormatado(CalculoTroco calculoTroco) {
        StringBuilder sb = new StringBuilder();
        int[] notas = {100, 50, 20, 10, 5, 2};
        double[] moedas = {1, 0.5, 0.25, 0.1, 0.05};
        boolean haMoedas = false;

        for(int i = 0; i < notas.length; i++)
            if (calculoTroco.getQuantidadeDeNotas()[i] > 0)
                sb.append(calculoTroco.getQuantidadeDeNotas()[i])
                        .append(" nota")
                        .append(calculoTroco.getQuantidadeDeNotas()[i] > 1 ? "s" : "")
                        .append(" de ")
                        .append(notas[i])
                        .append(" reais\n");

        for(int i = 0; i < moedas.length; i++)
            if(calculoTroco.getQuantidadeDeMoedas()[i] > 0) {
                haMoedas = true;
                sb.append(calculoTroco.getQuantidadeDeMoedas()[i])
                        .append(" moeda")
                        .append(calculoTroco.getQuantidadeDeMoedas()[i] > 1 ? "s" : "")
                        .append(" de ");
                if(moedas[i] == 1)
                    sb.append("1 real\n");
                else
                    sb.append((int) (moedas[i] * 100))
                            .append(" centavo")
                            .append(moedas[i] * 100 > 1 ? "s" : "")
                            .append("\n");
            }
        if(!haMoedas)
            sb.append("Não há troco em moeda.\n");
        return sb.toString();
    }
}