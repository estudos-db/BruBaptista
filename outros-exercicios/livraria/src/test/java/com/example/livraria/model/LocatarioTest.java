package com.example.livraria.model;

import static com.example.livraria.model.enums.Sexo.MASCULINO;
import static com.example.livraria.model.enums.Sexo.FEMININO;
import static com.example.livraria.model.enums.Sexo.OUTROS;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class LocatarioTest {

    Locatario locatario;
    Telefone telefone = new Telefone(20, 123456789);
    LocalDate nascimento = LocalDate.of(1990, 10, 22);
    @DisplayName("Deve criar um locatário válido")
    @Test
    void deveCriarLocatarioValido() {
        locatario = new Locatario("Locatario", OUTROS, telefone,
                "a@a.com", nascimento, 2);

        assertEquals("Locatario", locatario.getNome());
        assertEquals(OUTROS, locatario.getSexo());
        assertEquals(telefone.getTelefone(), locatario.getTelefone());
        assertEquals("a@a.com", locatario.getEmail());
        assertEquals(nascimento, locatario.getDataDeNascimento());
        assertEquals(2, locatario.getCpf());
    }

    @DisplayName("Deve retornar erro ao tentar criar um locatário com nome inválido")
    @Test
    void deveRetornarErroComNomeInvalido() {
        assertThrows(IllegalArgumentException.class, () ->
                locatario = new Locatario("", MASCULINO, telefone,
                        "a@a.com", nascimento, 3));
    }

    @DisplayName("Deve retornar erro ao tentar criar um locatário com email inválido")
    @Test
    void deveRetornarErroComEmailInvalido() {
        assertThrows(IllegalArgumentException.class, () ->
                locatario = new Locatario("Locatario", FEMININO, telefone,
                        "", nascimento, 4));
    }

    @DisplayName("Deve retornar erro ao tentar criar um locatário com data de nascimento inválida")
    @Test
    void deveRetornarErroComNascimentoInvalido() {
        LocalDate nascimentoErrado = LocalDate.of(1800, 10, 22);

        assertThrows(IllegalArgumentException.class, () ->
                locatario = new Locatario("Locatario", OUTROS, telefone,
                        "a@a.com", nascimentoErrado, 5));
    }

    @DisplayName("Deve retornar erro ao tentar criar um autor com cpf inválido")
    @Test
    void deveRetornarErroComCpfInvalido() {
        assertThrows(IllegalArgumentException.class, () ->
                locatario = new Locatario("Locatario", OUTROS, telefone,
                        "a@a.com", nascimento, 0));

        assertThrows(IllegalArgumentException.class, () ->
                locatario = new Locatario("Locatario", OUTROS, telefone,
                        "a@a.com", nascimento, -1));
    }
}