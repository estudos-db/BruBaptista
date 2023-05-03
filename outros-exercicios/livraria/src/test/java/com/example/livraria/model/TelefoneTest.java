package com.example.livraria.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TelefoneTest {

    Telefone telefone;
    
    @DisplayName("Deve retornar telefone com ddd e número")
    @Test
    void deveRetornarTelefone() {
        telefone = new Telefone(20, 123456789);

        assertEquals("(20)123456789", telefone.getTelefone());
    }
}