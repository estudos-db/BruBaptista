package com.example.livraria.model;

import static com.example.livraria.model.enums.Sexo.MASCULINO;
import static com.example.livraria.model.enums.Sexo.FEMININO;
import static com.example.livraria.model.enums.Sexo.OUTROS;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AutorTest {

    Autor autor;
    @DisplayName("Deve criar um autor válido")
    @Test
    void deveCriarAutorValido() {
        autor = new Autor("Autor", OUTROS, 1990, 1);

        assertEquals("Autor", autor.getNome());
        assertEquals(OUTROS, autor.getSexo());
        assertEquals(1990, autor.getAnoDeNascimento());
        assertEquals(1, autor.getCpf());
    }

    @DisplayName("Deve retornar erro ao tentar criar um autor com nome inválido")
    @Test
    void deveRetornarErroComNomeInvalido() {
        assertThrows(IllegalArgumentException.class, () ->
                autor = new Autor("", FEMININO, 1990, 2));
    }

    @DisplayName("Deve retornar erro ao tentar criar um autor com ano de nascimento inválido")
    @Test
    void deveRetornarErroComAnoInvalido() {
        assertThrows(IllegalArgumentException.class, () ->
                autor = new Autor("Autora", MASCULINO, 3023, 3));
    }

    @DisplayName("Deve retornar erro ao tentar criar um autor com cpf inválido")
    @Test
    void deveRetornarErroComCpfInvalido() {
        assertThrows(IllegalArgumentException.class, () ->
                autor = new Autor("Autora", MASCULINO, 3023, 0));

        assertThrows(IllegalArgumentException.class, () ->
                autor = new Autor("Autora", MASCULINO, 3023, -1));
    }
}