package org.example.exercicio20;

import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);
    private Estoque estoque = new Estoque();
    private Pedido pedido = new Pedido();

    public Menu(Estoque estoque) {
        this.estoque = estoque;
        this.pedido = new Pedido();
    }

    public void controlaMenuEstoque() {
        int opcao = 0;
        do {
            System.out.println("MENU");
            System.out.println("1. Mostrar estoque");
            System.out.println("2. Buscar produto por nome");
            System.out.println("3. Buscar produto por id");
            System.out.println("4. Adicionar produto");
            System.out.println("5. Adicionar pedido");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            System.out.println();
            switchCaseMenuEstoque(opcao);
        } while (opcao != 0);
    }

    private void switchCaseMenuEstoque(int opcao) {
        switch (opcao) {
            case 1 -> mostraEstoque();
            case 2 -> buscaProdutoNome();
            case 3 -> buscaProdutoId();
            case 4 -> adicionaProduto();
            case 5 -> menuPedido();
            case 0 -> System.out.println("Saindo...");
            default -> System.out.println("Opção inválida!\n");
        }
    }

    public void mostraEstoque() {
        estoque.imprimeCatalogoDoEstoque();
    }

    public void buscaProdutoNome() {
        System.out.print("Digite o nome do produto que deseja buscar: ");
        String nomeProduto = scanner.next();
        Produto produto = estoque.encontraProduto(nomeProduto);
        if(produto == null)
            System.out.println("Produto não encontrado!\n");
        else {
            StringBuilder sb = new StringBuilder();
            sb.append(produto.getQuantidadeEmEstoque())
                    .append("x ")
                    .append(produto.getNome())
                    .append(", por: ")
                    .append(produto.getPreco())
                    .append(" cada")
                    .append("\n");
            System.out.println(sb);
            menuEstoqueProduto(produto);
        }
    }

    public void buscaProdutoId() {
        System.out.print("Digite o ID do produto que deseja buscar: ");
        if(!scanner.hasNextInt()) {
            System.out.println("Erro, digite um número inteiro.\n");
            scanner.next();
            return;
        }
        int idProduto = scanner.nextInt();
        Produto produto = estoque.encontraProduto(idProduto);
        if(produto == null)
            System.out.println("Produto não encontrado!\n");
        else {
            StringBuilder sb = new StringBuilder();
            sb.append(produto.getQuantidadeEmEstoque())
                    .append("x ")
                    .append(produto.getNome())
                    .append(", por: ")
                    .append(produto.getPreco())
                    .append(" cada")
                    .append("\n");
            System.out.println(sb);
            menuEstoqueProduto(produto);
        }
    }

    public void adicionaProduto() {
        System.out.print("Digite o nome do produto que deseja adicionar: ");
        String nomeProduto = scanner.next();
        System.out.print("Digite o preço do produto: ");
        double precoProduto = scanner.nextDouble();
        System.out.print("Digite a quantidade do produto: ");
        int quantidadeProduto = scanner.nextInt();

        try {
            Produto novoProduto = new Produto(nomeProduto, precoProduto, quantidadeProduto);
            estoque.cadastraProduto(novoProduto);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Produto adicionado com sucesso!\n");
    }

    private void menuEstoqueProduto(Produto produto) {
        int opcao = 0;
        do {
            System.out.println("OPÇÕES DO PRODUTO:");
            System.out.println("1. Dar baixa em produto");
            System.out.println("2. Verificar quantidade do produto");
            System.out.println("3. Verificar posição do produto");
            System.out.println("0. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            switchCaseEstoqueProduto(opcao, produto);
        } while (opcao != 0);
    }

    private void switchCaseEstoqueProduto(int opcao, Produto produto) {
        switch (opcao) {
            case 1 -> realizaBaixa(produto);
            case 2 -> verificaQuantidade(produto);
            case 3 -> verificaPosicao(produto);
            case 0 -> System.out.println("Voltando ao menu principal...");
            default -> System.out.println("Opção inválida!\n");
        }
    }

    public void realizaBaixa(Produto produto) {
        System.out.print("Digite a quantidade de baixa: ");
        int quantidadeParaDarBaixa = scanner.nextInt();
        if (estoque.darBaixaEmEstoque(produto.getNome(), quantidadeParaDarBaixa))
            System.out.println("Baixa realizada com sucesso!\n");
        else
            System.out.println("Não foi possível realizar a baixa!\n");
    }

    public void verificaQuantidade(Produto produto) {
        int quantidade = estoque.getQuantidadeAtualEmEstoque(produto);
        if(quantidade == -1)
            System.out.println("Produto não encontrado!\n");
        else {
            StringBuilder sb = new StringBuilder();
            sb.append("Quantidade de ")
                    .append(produto.getNome())
                    .append(" disponível: ")
                    .append(quantidade)
                    .append("\n");
            System.out.println(sb);
        }
    }

    public void verificaPosicao(Produto produto) {
        int posicao = estoque.getPosicaoDoProdutoNaLista(produto);
        if(posicao != -1) {
            StringBuilder sb = new StringBuilder();
            sb.append("O produto ")
                    .append(produto.getNome())
                    .append(" está na posição ")
                    .append(posicao)
                    .append("\n");
            System.out.println(sb);
        }
        else
            System.out.println("Produto não encontrado no estoque!\n");
    }

    public void menuPedido() {
        int opcao = 0;
        do {
            System.out.println("MENU DO PEDIDO");
            System.out.println("1. Mostrar carrinho");
            System.out.println("2. Adicionar pedido");
            System.out.println("3. Remover pedido");
            System.out.println("4. Limpar carrinho");
            System.out.println("5. Ver valor total");
            System.out.println("6. Realizar pagamento");
            System.out.println("0. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            switchCaseMenuPedido(opcao);
        } while (opcao != 0);
    }

    private void switchCaseMenuPedido(int opcao) {
        switch (opcao) {
            case 1 -> mostraCarrinho();
            case 2 -> adicionaPedido();
            case 3 -> removePedido();
            case 4 -> limpaCarrinho();
            case 5 -> mostraValorTotal();
            case 6 -> realizaPagamento();
            case 0 -> System.out.println("Voltando ao menu principal...");
            default -> System.out.println("Opção inválida!\n");
        }
    }

    public void mostraCarrinho() {
        pedido.calculaValorTotal();
        pedido.imprimePedido();
    }

    public void mostraValorTotal() {
        pedido.calculaValorTotal();
        pedido.imprimeValorTotal();
    }

    public void adicionaPedido() {
        System.out.print("Digite o nome do produto: ");
        String nomeProduto = scanner.next();
        System.out.print("Digite a quantidade desejada: ");
        int quantidade = scanner.nextInt();

        Produto produto = estoque.encontraProduto(nomeProduto);
        if (produto == null) {
            System.out.println("Produto não encontrado.\n");
            return;
        }

        boolean adicionou = pedido.adicionaItemNaLista(produto, quantidade);
        if (adicionou)
            System.out.println("Produto adicionado ao carrinho.\n");
        else
            System.out.println("Não foi possível adicionar o produto.\n");
    }

    public void removePedido() {
        System.out.println("Remover Produto do Pedido");
        System.out.print("Nome do Produto: ");
        String nome = scanner.next();

        Produto produto = estoque.encontraProduto(nome);
        if (produto == null) {
            System.out.println("Produto não encontrado!\n");
            return;
        }

        boolean removido = pedido.removeItemDaLista(produto);
        if (removido)
            System.out.println("Produto removido do carrinho.\n");
        else
            System.out.println("Produto não encontrado no carrinho.\n");
    }

    public void limpaCarrinho() {
        pedido.limparCarrinho();
        System.out.println("Carrinho limpo!\n");
    }

    public void realizaPagamento() {
        System.out.print("Digite o valor pago: ");
        double valorPago = scanner.nextDouble();
        pedido.calculaValorTotal();

        try {
            if (valorPago < pedido.calculaValorTotal())
                System.out.println("Valor pago insuficiente.\n");
            else {
                double troco = Math.round((valorPago - pedido.calculaValorTotal()) * 100.0) / 100.0;
                System.out.printf("Pagamento realizado com sucesso.\nTroco: R$%.2f\n", troco);
                System.out.println();
                if(troco > 0) {
                    System.out.println("O troco são:");
                    System.out.print(pedido.calculaMenorQuantidadeDeNotas(troco));
                    System.out.println(pedido.calculaMenorQuantidadeDeMoedas(pedido.subtraiTroco(troco)));
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}