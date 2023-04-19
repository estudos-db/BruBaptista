package org.example.exercicio20;

import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    Estoque estoque;

    public Menu(Estoque estoque) {
        this.estoque = estoque;
    }

    public void controlaMenu() {
        int opcao = 0;
        do {
            System.out.println("MENU");
            System.out.println("1. Mostrar estoque");
            System.out.println("2. Buscar produto por nome");
            System.out.println("3. Buscar produto por id");
            System.out.println("4. Adicionar produto");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            switchCaseMenu(opcao);
        } while (opcao != 0);
    }

    private void switchCaseMenu(int opcao) {
        switch (opcao) {
            case 1 -> estoque.imprimeCatalogoDoEstoque();
            case 2 -> buscaProdutoNome();
            case 3 -> buscaProdutoId();
            case 4 -> adicionaProduto();
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
                    .append(" cada um")
                    .append("\n");
            System.out.println(sb);
            menuProduto(produto);
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
                    .append(" cada um")
                    .append("\n");
            System.out.println(sb);
            menuProduto(produto);
        }
    }

    public void adicionaProduto() {
        System.out.print("Digite o nome do produto que deseja adicionar: ");
        String nomeProduto = scanner.next();
        System.out.print("Digite o preço do produto: ");
        double precoProduto = scanner.nextDouble();
        System.out.print("Digite a quantidade do produto: ");
        int quantidadeProduto = scanner.nextInt();
        Produto novoProduto = new Produto(nomeProduto, precoProduto, quantidadeProduto);
        estoque.cadastraProduto(novoProduto);
        System.out.println("Produto adicionado com sucesso!\n");
    }

    private void menuProduto(Produto produto) {
        int opcao = 0;
        do {
            System.out.println("OPÇÕES DO PRODUTO:");
            System.out.println("1. Dar baixa em produto");
            System.out.println("2. Verificar quantidade do produto");
            System.out.println("3. Verificar posição do produto");
            System.out.println("0. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            switchCaseProduto(opcao, produto);
        } while (opcao != 0);
    }

    private void switchCaseProduto(int opcao, Produto produto) {
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
}