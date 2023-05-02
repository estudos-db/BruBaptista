package com.example.livraria.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TelefoneTest {

    Telefone telefone;
    @DisplayName("Deve criar um telefone válido")
    @Test
    void deveCriarTelefoneValido() {
        telefone = new Telefone(20, 123456789);

        assertEquals(20, telefone.getDdd());
        assertEquals(123456789, telefone.getNumero());
    }

    @DisplayName("Deve retornar erro ao tentar criar um telefone com ddd inválido")
    @Test
    void deveRetornarErroComDddInvalido() {
        assertThrows(IllegalArgumentException.class, () ->
                telefone = new Telefone(0, 123456789));
    }

    @DisplayName("Deve retornar erro ao tentar criar um telefone com ddd inválido")
    @Test
    void deveRetornarErroComNumeroInvalido() {
        assertThrows(IllegalArgumentException.class, () ->
                telefone = new Telefone(10, 0));
    }

    @DisplayName("Deve retornar telefone com ddd e número")
    @Test
    void deveRetornarTelefone() {
        telefone = new Telefone(20, 123456789);

        assertEquals("(20)123456789", telefone.getTelefone());
    }
}