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

    @DisplayName("Deve calcular o valor total do pedido")
    @Test
    void deveCalcularValorTotal() {
        pedido.adicionaItemNaLista(batata, 1);
        pedido.adicionaItemNaLista(tomate, 1);
        pedido.calculaValorTotal();

        assertEquals(25, pedido.getValorTotalDoPedido());
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
}