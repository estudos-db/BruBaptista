package org.example.exercicio18;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MotoPartidaPedalTest {

    MotoPartidaPedal motoPartidaPedal = new MotoPartidaPedal(50);
    @DisplayName("Deve puxar o acelerador, caso não esteja puxado")
    @Test
    void devePuxarAcelerador() {
        motoPartidaPedal.puxarAcelerador();

        assertTrue(motoPartidaPedal.isAceleradorPuxado());
    }

    @DisplayName("Deve retornar erro ao tentar puxar o acelerador, caso o acelerador já esteja puxado")
    @Test
    void deveRetornarErroComAceleradorPuxado() {
        motoPartidaPedal.puxarAcelerador();

        assertThrows(IllegalArgumentException.class, () ->
                motoPartidaPedal.puxarAcelerador());
    }

    @DisplayName("Deve retornar erro ao tentar ligar a moto sem o acelerador puxado")
    @Test
    void deveRetornarErroLigandoSemAceleradorPuxado() {
        assertThrows(IllegalArgumentException.class, () ->
                motoPartidaPedal.ligar());
    }

    @DisplayName("Deve ligar a moto, caso esteja desligada e com acelerador puxado")
    @Test
    void deveLigarMoto() {
        motoPartidaPedal.puxarAcelerador();
        motoPartidaPedal.ligar();

        assertTrue(motoPartidaPedal.isLigado());
    }

    @DisplayName("Deve retornar erro ao tentar ligar a moto, caso a moto já esteja ligada")
    @Test
    void deveRetornarErroComMotoLigada() {
        motoPartidaPedal.puxarAcelerador();
        motoPartidaPedal.ligar();

        assertThrows(IllegalArgumentException.class, () ->
                motoPartidaPedal.ligar());
    }

    @DisplayName("Deve desligar a moto, caso esteja ligada")
    @Test
    void deveDesligarMoto() {
        motoPartidaPedal.puxarAcelerador();
        motoPartidaPedal.ligar();
        motoPartidaPedal.desligar();

        assertFalse(motoPartidaPedal.isLigado());
    }

    @DisplayName("Deve retornar erro ao tentar desligar a moto, caso a moto já esteja desligada")
    @Test
    void deveRetornarErroComMotoDesligada() {
        assertThrows(IllegalArgumentException.class, () ->
                motoPartidaPedal.desligar());
    }
}