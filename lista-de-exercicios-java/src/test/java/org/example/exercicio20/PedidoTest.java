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

    @DisplayName("Deve calcular a quantidade de notas e o resto")
    @Test
    public void deveCalcularQuantidadeDeNotasEResto() {
        Pedido pedido = new Pedido();
        double valorTroco = 123.45;

        CalculoTroco calculoTroco = pedido.calculaQuantidadeDeNotas(valorTroco);

        assertArrayEquals(new int[]{1, 0, 1, 0, 0, 1}, calculoTroco.getQuantidadeDeNotas());
        assertEquals(145, calculoTroco.getResto());
    }

    @DisplayName("Deve calcular a quantidade de moedas")
    @Test
    void deveCalcularQuantidadeDeMoedas() {
        Pedido pedido = new Pedido();
        double troco = 5.75;
        CalculoTroco quantidadeDeNotas = pedido.calculaQuantidadeDeNotas(troco);
        CalculoTroco quantidadeDeMoedas = pedido.calculaQuantidadeDeMoedas(quantidadeDeNotas);

        assertArrayEquals(new int[]{0, 0, 0, 0, 1, 0}, quantidadeDeNotas.getQuantidadeDeNotas());
        assertArrayEquals(new int[]{0, 1, 1, 0, 0}, quantidadeDeMoedas.getQuantidadeDeMoedas());
        assertEquals(0, quantidadeDeMoedas.getResto());
    }

    @DisplayName("Deve gerar string de troco em notas e moedas")
    @Test
    void deveGerarStringTroco() {
        Pedido pedido = new Pedido();
        int[] quantidadeDeNotas = {0, 0, 0, 0, 1, 2};
        int[] quantidadeDeMoedas = {1, 1, 0, 2, 0};
        CalculoTroco calculoTroco = new CalculoTroco(quantidadeDeNotas, quantidadeDeMoedas);
        String expected = "1 nota de 5 reais\n" +
                "2 notas de 2 reais\n" +
                "1 moeda de 1 real\n" +
                "1 moeda de 50 centavos\n" +
                "2 moedas de 10 centavos\n";
        String result = pedido.geraTrocoFormatado(calculoTroco);
        assertEquals(expected, result);
    }

    @DisplayName("Deve gerar string de troco em notas e sem moedas")
    @Test
    void deveGerarStringTrocoSemMoedas() {
        Pedido pedido = new Pedido();
        int[] quantidadeDeNotas = {1, 0, 0, 0, 0, 0};
        int[] quantidadeDeMoedas = {0, 0, 0, 0, 0};
        CalculoTroco calculoTroco = new CalculoTroco(quantidadeDeNotas, quantidadeDeMoedas);
        String expected = "1 nota de 100 reais\n" +
                "Não há troco em moeda.\n";
        String result = pedido.geraTrocoFormatado(calculoTroco);
        assertEquals(expected, result);
    }
}