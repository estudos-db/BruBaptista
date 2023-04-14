package org.example.exercicio18;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GuinchoTest {

    Guincho guincho = new Guincho(10);
    @DisplayName("Deve carregar um carro caso não esteja carregando nada")
    @Test
    void deveCarregarUmCarro() {
        Carro carro = new Carro(15);
        guincho.carregar(carro);

        assertEquals(carro, guincho.getCarregando()[0]);
    }

    @DisplayName("Deve carregar uma moto caso não esteja carregando nada")
    @Test
    void deveCarregarUmaMoto() {
        Moto moto = new Moto(25);
        guincho.carregar(moto);

        assertEquals(moto, guincho.getCarregando()[0]);
    }

    @DisplayName("Deve retornar erro ao tentar carregar um veículo enquanto já está carregando um")
    @Test
    void deveRetornarErroEnquantoCarrega() {
        Moto moto = new Moto(25);
        CarroAutomatico carroAutomatico = new CarroAutomatico(20);
        guincho.carregar(moto);

        assertThrows(IllegalArgumentException.class, () ->
                guincho.carregar(carroAutomatico));
    }

    @DisplayName("Deve soltar o veículo que está sendo carregado")
    @Test
    void deveSoltarVeiculo() {
        MotoPartidaPedal motoPartidaPedal = new MotoPartidaPedal(30);
        guincho.carregar(motoPartidaPedal);
        assertEquals(motoPartidaPedal, guincho.getCarregando()[0]);

        guincho.soltar();
        assertNull(guincho.getCarregando()[0]);
    }

    @DisplayName("Deve retornar erro ao tentar soltar um veículo enquanto carrega nenhum")
    @Test
    void deveRetornarErroSemCarregarVeiculo() {
        assertThrows(IllegalArgumentException.class, () ->
                guincho.soltar());
    }
}