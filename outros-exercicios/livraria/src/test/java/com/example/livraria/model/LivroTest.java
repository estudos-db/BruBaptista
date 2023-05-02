package com.example.livraria.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class LivroTest {

    Livro livro;
    LocalDate dataDePublicacao = LocalDate.of(1990, 10, 22);
    @DisplayName("Deve criar um livro válido")
    @Test
    void deveCriarLivroValido() {
        livro = new Livro("Livro", 1, dataDePublicacao);

        assertEquals("Livro", livro.getNome());
        assertEquals(1, livro.getIsbn());
        assertEquals(dataDePublicacao, livro.getDataDePublicacao());
    }

    @DisplayName("Deve retornar erro ao tentar criar um livro com nome inválido")
    @Test
    void deveRetornarErroComNomeInvalido() {
        assertThrows(IllegalArgumentException.class, () ->
                livro = new Livro("", 2, dataDePublicacao));
    }

    @DisplayName("Deve retornar erro ao tentar criar um livro com nome inválido")
    @Test
    void deveRetornarErroComIsbnInvalido() {
        assertThrows(IllegalArgumentException.class, () ->
                livro = new Livro("Livro", 0, dataDePublicacao));

        assertThrows(IllegalArgumentException.class, () ->
                livro = new Livro("Livro", -1, dataDePublicacao));
    }
}