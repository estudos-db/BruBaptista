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
        } while (opcao != 7);
    }

    private void switchCaseMenu(int opcao) {
        switch (opcao) {
            case 1 -> estoque.imprimeCatalogoDoEstoque();
            case 2 -> buscaProdutoNome();
            case 3 -> buscaProdutoId();
            case 4 -> adicionaProduto();
            case 0 -> System.out.println("Saindo...");
            default -> System.out.println("Opção inválida!");
        }
    }

    public void mostraEstoque() {
        estoque.imprimeCatalogoDoEstoque();
    }

    public void buscaProdutoNome() {
        System.out.print("Digite o nome do produto que deseja buscar: ");
        String nomeProduto = scanner.next();
        Produto produto = estoque.encontraProduto(nomeProduto);
        if (produto == null) {
            System.out.println("Produto não encontrado!");
        } else {
            System.out.println(produto);
        }
    }

    public void buscaProdutoId() {
        System.out.print("Digite o ID do produto que deseja buscar: ");
        int idProduto = scanner.nextInt();
        Produto produto = estoque.encontraProduto(idProduto);
        if (produto == null) {
            System.out.println("Produto não encontrado!");
        } else {
            System.out.println(produto);
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
        } while (opcao != 4);
    }

    private void switchCaseProduto(int opcao, Produto produto) {
        switch (opcao) {
            case 1 -> darBaixa(produto);
            case 2 -> verificaQuantidade(produto);
            case 3 -> verificaPosicao(produto);
            case 0 -> System.out.println("Voltando ao menu principal...");
            default -> System.out.println("Opção inválida!");
        }
    }

    public void darBaixa(Produto produto) {
        System.out.print("Digite a quantidade que deseja dar baixa: ");
        int quantidadeBaixa = scanner.nextInt();
        estoque.darBaixaEmEstoque(produto.getId(), quantidadeBaixa);
    }

    public void verificaQuantidade(Produto produto) {
        int quantidade = estoque.getQuantidadeAtualEmEstoque(produto);
        if (quantidade == -1) {
            System.out.println("Produto não encontrado!");
        } else {
            System.out.println("Quantidade disponível: " + quantidade);
        }
    }

    public void verificaPosicao(Produto produto) {
        int posicao = estoque.getPosicaoDoProdutoNaLista(produto);
        if (posicao != -1) {
            System.out.println("O produto está na posição " + posicao);
        } else {
            System.out.println("Produto não encontrado no estoque.");
        }
    }
}