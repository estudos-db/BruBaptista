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
                produto = new Produto("batata", -10, 1));

        assertThrows(IllegalArgumentException.class, () ->
                produto = new Produto("batata", 0, 1));
    }

    @DisplayName("Deve retornar erro ao setar a quantidade em zero ou negativo")
    @Test
    void deveRetornarErroQuantidadeNegativa() {
        assertThrows(IllegalArgumentException.class, () ->
                produto = new Produto("batata", 10, -10));
    }

    @DisplayName("Deve aumentar o id em 1 a cada novo produto criado")
    @Test
    void deveAumentarId() {
        Produto batata = new Produto("batata", 10, 1);
        Produto tomate = new Produto("tomate", 15, 1);
        Produto alface = new Produto("alface", 5, 1);

        assertEquals(2, batata.getId());
        assertEquals(3, tomate.getId());
        assertEquals(4, alface.getId());
    }
}