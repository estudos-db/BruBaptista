package org.example.exercicio02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.*;
class ProdutoTest {
    @DisplayName("Deve retornar o noem do produto")
    @Test
    void nomeProduto() {
        Produto beterraba = new Produto("beterraba", new BigDecimal(1), 1);

        assertEquals("beterraba", beterraba.getNome());
    }

    @DisplayName("Não deve conter um preço negativo")
    @Test
    void precoMaiorZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Produto("tomate", new BigDecimal(-10), 1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Produto("outro tomate", new BigDecimal(0), 1);
        });
    }

    @DisplayName("Não deve conter uma quantidade negativa")
    @Test
    void quantidadeMaiorZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Produto("batata", new BigDecimal(1), -10);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Produto("outra batata", new BigDecimal(1), 0);
        });
    }

    @DisplayName("Deve retornar a quantidade do produto")
    @Test
    void recebendoQuantidade() {
        Produto pimenta = new Produto("pimenta", new BigDecimal(1), 1);

        assertEquals(1, pimenta.getQuantidade());
    }

    @DisplayName("Deve somar a quantidade do produto com a quantidade definida")
    @Test
    void somandoQuantidade() {
        Produto alface = new Produto("alface", new BigDecimal(1), 1);
        alface.aumentarQuantidade(10);

        assertEquals(11, alface.getQuantidade());
    }

    @DisplayName("Deve subtrair a quantidade do produto com a quantidade definida")
    @Test
    void diminuindoQuantidade() {
        Produto cebola = new Produto("cebola", new BigDecimal(1), 10);
        cebola.diminuirQuantidade(9);

        assertEquals(1, cebola.getQuantidade());
    }

    @DisplayName("Deve diminuir o valor de acordo com a quantidade do produto")
    @Test
    void descontos() {
        Produto cenoura = new Produto("cenoura", new BigDecimal(1), 1);
        BigDecimal valor1 = new BigDecimal(1).setScale(2, RoundingMode.HALF_UP);

        assertEquals(1, cenoura.getQuantidade());
        assertEquals(valor1, cenoura.getPreco());

        cenoura.aumentarQuantidade(10);
        BigDecimal valor2 = new BigDecimal(9.90).setScale(2, RoundingMode.HALF_UP);

        assertEquals(11, cenoura.getQuantidade());
        assertEquals(valor2, cenoura.getPreco());

        cenoura.aumentarQuantidade(10);
        BigDecimal valor3 = new BigDecimal(16.80).setScale(2, RoundingMode.HALF_UP);

        assertEquals(21, cenoura.getQuantidade());
        assertEquals(valor3, cenoura.getPreco());

        cenoura.aumentarQuantidade(30);
        BigDecimal valor4 = new BigDecimal(38.25).setScale(2, RoundingMode.HALF_UP);

        assertEquals(51, cenoura.getQuantidade());
        assertEquals(valor4, cenoura.getPreco());
    }

    @DisplayName("Deve retornar uma string com a quantidade, nome e valor total dos produtos")
    @Test
    void produtoInfo() {
        Produto pizza = new Produto("pizza", new BigDecimal(10), 1);

        assertEquals("Você está comprando 1 unidades de pizza pelo valor de 10.00 reais", pizza.getProduto());
    }
}