package com.example.livraria.service;

import com.example.livraria.model.Autor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class AutorServiceTest {

    @InjectMocks
    AutorService autorService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @DisplayName("Deve modificar o nome do autor")
    @Test
    public void deveModificarNome() {
        Autor autor = new Autor();
        autor.setNome("Teste");
        autorService.setNome("NovoNome", autor);

        assertEquals("NovoNome", autor.getNome());
    }

    @DisplayName("Deve retornar erro se o nome do autor for nulo ou vazio")
    @Test
    public void deveRetornarErroNomeNuloOuVazio() {
        Autor autor = new Autor();
        autor.setNome("Teste");

        assertThrows(IllegalArgumentException.class, () ->
                autorService.setNome("", autor));

        assertThrows(IllegalArgumentException.class, () ->
                autorService.setNome(null, autor));
    }

    @DisplayName("Deve modificar o ano de nascimento do autor")
    @Test
    public void deveModificarAno() {
        Autor autor = new Autor();
        autor.setAnoDeNascimento(1990);
        autorService.setAnoDeNascimento(1991, autor);

        assertEquals(1991, autor.getAnoDeNascimento());
    }

    @DisplayName("Deve retornar erro se o ano de nascimento do autor for nulo ou maior que o ano atual")
    @Test
    public void deveRetornarErroAnoNuloOuMaiorQueAtual() {
        Autor autor = new Autor();
        autor.setAnoDeNascimento(1990);

        assertThrows(IllegalArgumentException.class, () ->
                autorService.setAnoDeNascimento(3030, autor));

        assertThrows(IllegalArgumentException.class, () ->
                autorService.setAnoDeNascimento(null, autor));
    }

    @DisplayName("Deve modificar o cpf do autor")
    @Test
    public void deveModificarCpf() {
        Autor autor = new Autor();
        autor.setCpf(123456789);
        autorService.setcpf(987654321, autor);

        assertEquals(987654321, autor.getCpf());
    }

    @DisplayName("Deve retornar erro se o cpf do autor for nulo, zero ou menor")
    @Test
    public void deveRetornarErroCpfNuloZeroOuMenor() {
        Autor autor = new Autor();
        autor.setCpf(123456789);

        assertThrows(IllegalArgumentException.class, () ->
                autorService.setcpf(null, autor));

        assertThrows(IllegalArgumentException.class, () ->
                autorService.setcpf(0, autor));

        assertThrows(IllegalArgumentException.class, () ->
                autorService.setcpf(-10, autor));
    }
}