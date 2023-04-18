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
            if (valorPago < getValorTotalDoPedido()) {
                throw new IllegalArgumentException("Valor pago insuficiente.");
            }
            return valorPago - getValorTotalDoPedido();
        }
    }