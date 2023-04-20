package org.example.exercicio20;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PedidoTest {

    Produto batata = new Produto("batata", 10, 1);
    Produto tomate = new Produto("tomate", 15, 1);
    Pedido pedido = new Pedido();

    @DisplayName("Deve adicionar um item na lista de itens")
    @Test
    void deveAdicionarItenNaLista() {
        pedido.adicionaItemNaLista(batata, 1);

        assertEquals(1, pedido.getListaDeItens().size());
        assertEquals(batata, pedido.getListaDeItens().get(0).getProduto());
    }

    @DisplayName("Deve aumentar a quantidade de um produto que já está na lista")
    @Test
    void deveAumentarQuantidadeDeProdutoPresenteNaLista() {
        pedido.adicionaItemNaLista(batata, 1);
        pedido.adicionaItemNaLista(batata, 1);

        assertEquals(1, pedido.getListaDeItens().size());
        assertEquals(batata, pedido.getListaDeItens().get(0).getProduto());
        assertEquals(2, pedido.getListaDeItens().get(0).getQuantidade());
    }

    @DisplayName("Deve remover um item na lista de itens")
    @Test
    void deveRemoverItenNaLista() {
        pedido.adicionaItemNaLista(batata, 1);
        pedido.removeItemDaLista(batata);

        assertTrue(pedido.getListaDeItens().isEmpty());
    }

    @DisplayName("Deve calcular o valor total do pedido")
    @Test
    void deveCalcularValorTotal() {
        pedido.adicionaItemNaLista(batata, 1);
        pedido.adicionaItemNaLista(tomate, 1);
        pedido.calculaValorTotal();

        assertEquals(25, pedido.calculaValorTotal());
    }

    @DisplayName("Deve limpar a lista de itens")
    @Test
    void deveLimparLista() {
        pedido.adicionaItemNaLista(batata, 1);
        assertEquals(1, pedido.getListaDeItens().size());

        pedido.limparCarrinho();
        assertEquals(0, pedido.getListaDeItens().size());
    }

    @DisplayName("Deve retornar o troco")
    @Test
    void deveRetornarTroco() {
        pedido.adicionaItemNaLista(batata, 1);
        pedido.calculaValorTotal();

        assertEquals(5.0, pedido.calculaTroco(15));
    }

    @DisplayName("Deve retornar erro se o valor pago for menor que o total a pagar")
    @Test
    void deveRetornarErroValorPagoMenor() {
        pedido.adicionaItemNaLista(batata, 1);
        pedido.calculaValorTotal();

        assertThrows(IllegalArgumentException.class, () ->
                pedido.calculaTroco(5));
    }

    @DisplayName("Deve retornar as notas para troco")
    @Test
    void deveRetornarNotasDeTroco() {
        assertEquals("1 nota de 100 reais\n" +
                "1 nota de 50 reais\n" +
                "1 nota de 20 reais\n" +
                "1 nota de 10 reais\n" +
                "1 nota de 5 reais\n" +
                "2 notas de 2 reais\n", pedido.calculaMenorQuantidadeDeNotas(189));
    }

    @DisplayName("Deve retornar as moedas para troco")
    @Test
    void deveRetornarMoedasDeTroco() {
        assertEquals("1 moeda de 1 real\n" +
                "1 moeda de 50 centavos\n" +
                "1 moeda de 25 centavos\n" +
                "1 moeda de 10 centavos\n", pedido.calculaMenorQuantidadeDeMoedas(1.87));
    }

    @DisplayName("Não deve calcular moedas de troco para valor 2 ou mais")
    @Test
    void naoDeveRetornarTrocoPara2OuMais() {
        assertEquals("Valor do troco deve ser menor que 2",
                pedido.calculaMenorQuantidadeDeMoedas(2));
        assertEquals("Valor do troco deve ser menor que 2",
                pedido.calculaMenorQuantidadeDeMoedas(3));
    }

    @DisplayName("Deve retornar o valor do troco subtraído pelo valor das notas usadas para o troco")
    @Test
    void deveRetornarTrocoSubtraido() {
        assertEquals(1, pedido.subtraiTroco(11));
    }
}