package org.example.exercicio20;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EstoqueTest {

    Produto batata = new Produto(1, "batata", 10, 1);
    Produto tomate = new Produto(2, "tomate", 15, 1);
    Estoque estoque = new Estoque();

    @DisplayName("Deve adicionar o produto no estoque")
    @Test
    void deveAdicionarProduto() {
        estoque.inicializaEstoque();
        estoque.cadastraProduto(batata);

        assertTrue(estoque.listaDeProdutos.contains(batata));
    }

    @DisplayName("Deve aumentar a quantidade do produto, caso o estoque já contenha esse produto")
    @Test
    void deveAumentarQuantidadeProduto() {
        estoque.inicializaEstoque();
        estoque.cadastraProduto(batata);
        estoque.cadastraProduto(batata);

        assertEquals(2, batata.getQuantidadeEmEstoque());
    }

    @DisplayName("Deve encontrar o produto no estoque pelo nome")
    @Test
    void deveEncontrarProdutoPorNome() {
        estoque.inicializaEstoque();
        estoque.cadastraProduto(batata);

        assertEquals(batata, estoque.encontraProduto("batata"));
    }

    @DisplayName("Deve retornar nulo caso o produto não seja encontrado por nome")
    @Test
    void deveRetornarNuloSemEncontrarProdutoPorNome() {
        estoque.inicializaEstoque();

        assertNull(estoque.encontraProduto("batata"));
    }

    @DisplayName("Deve encontrar o produto no estoque pelo id")
    @Test
    void deveEncontrarProdutoPorId() {
        estoque.inicializaEstoque();
        estoque.cadastraProduto(batata);

        assertEquals(batata, estoque.encontraProduto(1));
    }

    @DisplayName("Deve retornar nulo caso o produto não seja encontrado por id")
    @Test
    void deveRetornarNuloSemEncontrarProdutoPorId() {
        estoque.inicializaEstoque();

        assertNull(estoque.encontraProduto(1));
    }

    @DisplayName("Deve verificar se o produto está ou não em estoque")
    @Test
    void deveVerificarPresencaNoEstoque() {
        estoque.inicializaEstoque();
        estoque.cadastraProduto(batata);

        assertTrue(estoque.temEstoqueOuNao(batata, 1));

        assertFalse(estoque.temEstoqueOuNao(tomate, 1));
    }

    @DisplayName("Deve verificar a quantidade do produto para dar baixa")
    @Test
    void deveVerificarQuantidadeNoEstoque() {
        estoque.inicializaEstoque();
        estoque.cadastraProduto(batata);

        assertFalse(estoque.temEstoqueOuNao(batata, 2));
    }

    @DisplayName("Deve diminuir a quantidade de um produto buscado por nome")
    @Test
    void deveDiminuirQuantidadeProdutoNome() {
        estoque.inicializaEstoque();
        estoque.cadastraProduto(batata);

        assertTrue(estoque.darBaixaEmEstoque("batata", 1));
        assertEquals(0, batata.getQuantidadeEmEstoque());
    }

    @DisplayName("Deve diminuir a quantidade de um produto buscado por id")
    @Test
    void deveDiminuirQuantidadeProdutoId() {
        estoque.inicializaEstoque();
        estoque.cadastraProduto(batata);

        assertTrue(estoque.darBaixaEmEstoque(1, 1));
        assertEquals(0, batata.getQuantidadeEmEstoque());
    }

    @DisplayName("Deve retornar a quantidade do produto em estoque")
    @Test
    void deveRetornarQuantidade() {
        estoque.inicializaEstoque();
        estoque.cadastraProduto(batata);
        assertEquals(1, estoque.getQuantidadeAtualEmEstoque(batata));

        estoque.darBaixaEmEstoque("batata", 1);
        assertEquals(0, estoque.getQuantidadeAtualEmEstoque(batata));

        assertEquals(0, estoque.getQuantidadeAtualEmEstoque(tomate));
    }

    @DisplayName("Deve retornar a posição do produto na lista")
    @Test
    void deveRetornarPosicaoLista() {
        estoque.inicializaEstoque();
        estoque.cadastraProduto(batata);
        estoque.cadastraProduto(tomate);

        assertEquals(0, estoque.getPosicaoDoProdutoNaLista(batata));
        assertEquals(1, estoque.getPosicaoDoProdutoNaLista(tomate));
    }

    @DisplayName("Deve retornar '-1' quando o produto não está na lista")
    @Test
    void deveRetornarMenosUm() {
        estoque.inicializaEstoque();

        assertEquals(-1, estoque.getPosicaoDoProdutoNaLista(batata));
    }
}