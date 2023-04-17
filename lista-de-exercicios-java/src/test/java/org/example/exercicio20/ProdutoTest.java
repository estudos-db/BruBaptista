package org.example.exercicio20;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProdutoTest {

    Produto produto;
    @DisplayName("Deve retornar erro ao setar o preço em zero ou negativo")
    @Test
    void deveRetornarErroPrecoZeroOuNegativo() {
        assertThrows(IllegalArgumentException.class, () ->
                produto = new Produto(1, "batata", -10, 1));

        assertThrows(IllegalArgumentException.class, () ->
                produto = new Produto(1, "batata", 0, 1));
    }

    @DisplayName("Deve retornar erro ao setar a quantidade em zero ou negativo")
    @Test
    void deveRetornarErroQuantidadeNegativa() {
        assertThrows(IllegalArgumentException.class, () ->
                produto = new Produto(1, "batata", 10, -10));
    }
}