package org.example.exercicio20;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    Produto batata = new Produto(1, "batata", 10, 1);
    Item item;
    @DisplayName("Deve retornar erro ao setar a quantidade em zero ou negativo")
    @Test
    void deveRetornarErroQuantidadeZeroOuNegativo() {
        assertThrows(IllegalArgumentException.class, () ->
                item = new Item(batata, -10));

        assertThrows(IllegalArgumentException.class, () ->
                item = new Item(batata, 0));
    }

    @DisplayName("Deve retornar o valor total")
    @Test
    void deveRetornarValorTotal() {
        item = new Item(batata, 10);

        assertEquals(100, item.defineValorTotal());
    }
}