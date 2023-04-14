package org.example.exercicio18;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AutomovelTest {

    Automovel automovel = new Automovel(3, 20);
    @DisplayName("Deve ligar o carro, caso esteja desligado")
    @Test
    void deveLigarCarro() {
        automovel.ligar();

        assertTrue(automovel.isLigado());
    }

    @DisplayName("Deve retornar erro ao tentar ligar o carro, caso o carro já esteja ligado")
    @Test
    void deveRetornarErroComCarroLigado() {
        automovel.ligar();

        assertThrows(IllegalArgumentException.class, () ->
                automovel.ligar());
    }

    @DisplayName("Deve desligar o carro, caso esteja ligado")
    @Test
    void deveDesligarCarro() {
        automovel.ligar();
        automovel.desligar();

        assertFalse(automovel.isLigado());
    }

    @DisplayName("Deve retornar erro ao tentar desligar o carro, caso o carro já esteja desligado")
    @Test
    void deveRetornarErroComCarroDesligado() {
        assertThrows(IllegalArgumentException.class, () -> automovel.desligar());
    }
}