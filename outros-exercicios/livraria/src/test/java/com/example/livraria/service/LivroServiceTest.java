package com.example.livraria.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.example.livraria.dto.LivroDto;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

public class LivroServiceTest {

    @InjectMocks
    LivroService livroService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @DisplayName("Deve modificar o nome do livro")
    @Test
    public void deveModificarNome() {
        LivroDto livroDto = new LivroDto();
        livroDto.setNome("Teste");
        livroService.setNome("NovoNome", livroDto);

        assertEquals("NovoNome", livroDto.getNome());
    }

    @DisplayName("Deve retornar erro se o nome do livro for nulo ou vazio")
    @Test
    public void deveRetornarErroNomeNuloOuVazio() {
        LivroDto livroDto = new LivroDto();
        livroDto.setNome("Teste");

        assertThrows(IllegalArgumentException.class, () ->
                livroService.setNome("", livroDto));

        assertThrows(IllegalArgumentException.class, () ->
                livroService.setNome(null, livroDto));
    }

    @DisplayName("Deve modificar o isbn do livro")
    @Test
    public void deveModificarIsbn() {
        LivroDto livroDto = new LivroDto();
        livroDto.setIsbn(123456789);
        livroService.setIsbn(987654321, livroDto);

        assertEquals(987654321, livroDto.getIsbn());
    }

    @DisplayName("Deve retornar erro se o isbn do livro for nulo, zero ou menor")
    @Test
    public void deveRetornarErroIsbnNuloZeroOuMenor() {
        LivroDto livroDto = new LivroDto();
        livroDto.setIsbn(123456789);

        assertThrows(IllegalArgumentException.class, () ->
                livroService.setIsbn(null, livroDto));

        assertThrows(IllegalArgumentException.class, () ->
                livroService.setIsbn(0, livroDto));

        assertThrows(IllegalArgumentException.class, () ->
                livroService.setIsbn(-10, livroDto));
    }

    @DisplayName("Deve modificar a data de publicação do livro")
    @Test
    public void deveModificarAno() {
        LocalDate data = LocalDate.of(1990, 5, 10);
        LocalDate data2 = LocalDate.of(1991, 6, 11);

        LivroDto livroDto = new LivroDto();
        livroDto.setDataDePublicacao(data);
        livroService.setDataDePublicacao(data2, livroDto);

        assertEquals(data2, livroDto.getDataDePublicacao());
    }

    @DisplayName("Deve retornar erro se a data de publicação do livro for nulo")
    @Test
    public void deveRetornarErroDataDePublicacaoNulo() {
        LocalDate data = LocalDate.of(1990, 5, 10);
        LivroDto livroDto = new LivroDto();
        livroDto.setDataDePublicacao(data);

        assertThrows(IllegalArgumentException.class, () ->
                livroService.setDataDePublicacao(null, livroDto));
    }
}