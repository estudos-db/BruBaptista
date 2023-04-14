package org.example.exercicio18;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CarroAutomaticoTest {

    CarroAutomatico carroAutomatico = new CarroAutomatico(20);
    @DisplayName("Deve pressionar o freio, caso não esteja pressionado")
    @Test
    void devePressionarFreio() {
        carroAutomatico.pressionarFreio();

        assertTrue(carroAutomatico.isFreioPressionado());
    }

    @DisplayName("Deve retornar erro ao tentar pressionar o freio, caso o freio já esteja pressionado")
    @Test
    void deveRetornarErroComFreioPressionado() {
        carroAutomatico.pressionarFreio();

        assertThrows(IllegalArgumentException.class, () ->
                carroAutomatico.pressionarFreio());
    }

    @DisplayName("Deve retornar erro ao tentar ligar o carro sem o freio pressionado")
    @Test
    void deveRetornarErroLigandoSemFreioPressionado() {
        assertThrows(IllegalArgumentException.class, () ->
            carroAutomatico.ligar());
    }

    @DisplayName("Deve ligar o carro, caso esteja desligado e com freio pressionado")
    @Test
    void deveLigarCarro() {
        carroAutomatico.pressionarFreio();
        carroAutomatico.ligar();

        assertTrue(carroAutomatico.isLigado());
    }

    @DisplayName("Deve retornar erro ao tentar ligar o carro, caso o carro já esteja ligado")
    @Test
    void deveRetornarErroComCarroLigado() {
        carroAutomatico.pressionarFreio();
        carroAutomatico.ligar();

        assertThrows(IllegalArgumentException.class, () ->
            carroAutomatico.ligar());
    }

    @DisplayName("Deve desligar o carro, caso esteja ligado")
    @Test
    void deveDesligarCarro() {
        carroAutomatico.pressionarFreio();
        carroAutomatico.ligar();
        carroAutomatico.desligar();

        assertFalse(carroAutomatico.isLigado());
    }

    @DisplayName("Deve retornar erro ao tentar desligar o carro, caso o carro já esteja desligado")
    @Test
    void deveRetornarErroComCarroDesligado() {
        assertThrows(IllegalArgumentException.class, () ->
            carroAutomatico.desligar());
    }
}