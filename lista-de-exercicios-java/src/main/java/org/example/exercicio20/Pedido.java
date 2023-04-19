    package org.example.exercicio20;

    import java.util.ArrayList;
    import java.util.Scanner;

    public class Pedido {
        private ArrayList<Item> listaDeItens = new ArrayList<>();
        private double valorTotalDoPedido = 0;

        public void calculaValorTotal() {
            for(Item item : listaDeItens) {
                valorTotalDoPedido += item.defineValorTotal();
            }
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

        public void imprimePedido() {
            if(listaDeItens.size() == 0)
                System.out.println("Lista vazia");
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
                    .append(getValorTotalDoPedido());
            System.out.println(sb);
        }

        public void imprimeValorTotal() {
            System.out.println("O valor total é: " + getValorTotalDoPedido());
        }

        public String recebeNomeDoTeclado() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Digite o nome do produto: ");
            return scanner.nextLine();
        }

        public int recebeQuantidadeDoTeclado() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Digite a quantidade desejada: ");
            return scanner.nextInt();
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
            if(valorPago < getValorTotalDoPedido()) {
                throw new IllegalArgumentException("Valor pago insuficiente.");
            }
            return valorPago - getValorTotalDoPedido();
        }

        public String calculaMenorQuantidadeDeNotas(double valorTroco) {
            int[] notas = {100, 50, 20, 10, 5, 2};
            int[] quantidadeDeNotas = calculaQuantidadeDeNotas(valorTroco, notas);

            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < notas.length; i++)
                if(quantidadeDeNotas[i] > 0)
                    sb.append(quantidadeDeNotas[i])
                            .append(" nota")
                            .append(quantidadeDeNotas[i] > 1 ? "s" : "")
                            .append(" de ")
                            .append(notas[i])
                            .append(" reais\n");
            return sb.toString();
        }

        public String calculaMenorQuantidadeDeMoedas(double valorTroco) {
            if (valorTroco >= 2)
                return "Valor do troco deve ser menor que 2";

            double[] moedas = {1, 0.5, 0.25, 0.1, 0.05};
            int[] quantidadeDeMoedas = calculaQuantidadeDeMoedas(valorTroco, moedas);

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < moedas.length; i++)
                if (quantidadeDeMoedas[i] > 0) {
                    sb.append(quantidadeDeMoedas[i])
                            .append(" moeda")
                            .append(quantidadeDeMoedas[i] > 1 ? "s" : "")
                            .append(" de ");
                    if (moedas[i] == 1)
                        sb.append("1 real");
                    else
                        sb.append((int) (moedas[i] * 100))
                                .append(" centavo")
                                .append(moedas[i] * 100 > 1 ? "s" : "");
                    sb.append("\n");
                }
            return sb.toString();
        }

        private int[] calculaQuantidadeDeMoedas(double valorTroco, double[] moedas) {
            int[] quantidadeDeMoedas = new int[moedas.length];
            for(int i = 0; i < moedas.length; i++)
                if(valorTroco >= moedas[i]) {
                    quantidadeDeMoedas[i] = (int) (valorTroco / moedas[i]);
                    valorTroco -= quantidadeDeMoedas[i] * moedas[i];
                }
            return quantidadeDeMoedas;
        }

        private int[] calculaQuantidadeDeNotas(double valorTroco, int[] notas) {
            int[] quantidadeDeNotas = new int[notas.length];
            for(int i = 0; i < notas.length; i++)
                if(valorTroco >= notas[i]) {
                    quantidadeDeNotas[i] = (int) (valorTroco / notas[i]);
                    valorTroco -= quantidadeDeNotas[i] * notas[i];
                }
            return quantidadeDeNotas;
        }
    }