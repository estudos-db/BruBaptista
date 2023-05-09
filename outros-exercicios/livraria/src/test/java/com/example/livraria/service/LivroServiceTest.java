package com.example.livraria.service;

import com.example.livraria.model.Autor;
import com.example.livraria.model.Livro;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
        Livro livro = new Livro();
        livro.setNome("Teste");
        livroService.setNome("NovoNome", livro);

        assertEquals("NovoNome", livro.getNome());
    }

    @DisplayName("Deve retornar erro se o nome do livro for nulo ou vazio")
    @Test
    public void deveRetornarErroNomeNuloOuVazio() {
        Livro livro = new Livro();
        livro.setNome("Teste");

        assertThrows(IllegalArgumentException.class, () ->
                livroService.setNome("", livro));

        assertThrows(IllegalArgumentException.class, () ->
                livroService.setNome(null, livro));
    }

    @DisplayName("Deve modificar o isbn do livro")
    @Test
    public void deveModificarIsbn() {
        Livro livro = new Livro();
        livro.setIsbn(123456789);
        livroService.setIsbn(987654321, livro);

        assertEquals(987654321, livro.getIsbn());
    }

    @DisplayName("Deve retornar erro se o isbn do livro for nulo, zero ou menor")
    @Test
    public void deveRetornarErroIsbnNuloZeroOuMenor() {
        Livro livro = new Livro();
        livro.setIsbn(123456789);

        assertThrows(IllegalArgumentException.class, () ->
                livroService.setIsbn(null, livro));

        assertThrows(IllegalArgumentException.class, () ->
                livroService.setIsbn(0, livro));

        assertThrows(IllegalArgumentException.class, () ->
                livroService.setIsbn(-10, livro));
    }

    @DisplayName("Deve modificar a data de publicação do livro")
    @Test
    public void deveModificarAno() {
        LocalDate data = LocalDate.of(1990, 5, 10);
        LocalDate data2 = LocalDate.of(1991, 6, 11);

        Livro livro = new Livro();
        livro.setDataDePublicacao(data);
        livroService.setDataDePublicacao(data2, livro);

        assertEquals(data2, livro.getDataDePublicacao());
    }

    @DisplayName("Deve retornar erro se a data de publicação do livro for nulo")
    @Test
    public void deveRetornarErroDataDePublicacaoNulo() {
        LocalDate data = LocalDate.of(1990, 5, 10);
        Livro livro = new Livro();
        livro.setDataDePublicacao(data);

        assertThrows(IllegalArgumentException.class, () ->
                livroService.setDataDePublicacao(null, livro));
    }

    @DisplayName("Deve modificar os autores do livro")
    @Test
    public void deveModificarutores() {
        Autor autor = new Autor();
        List<Autor> autores = new ArrayList<>();
        Livro livro = new Livro();
        autores.add(autor);
        livroService.setAutores(autores, livro);

        assertEquals(autores, livro.getAutores());
    }

    @DisplayName("Deve retornar erro se os autores do livro forem nulo ou vazio")
    @Test
    public void deveRetornarErroutoresNuloOuVazio() {
        Autor autor = new Autor();
        List<Autor> autores = new ArrayList<>();
        List<Autor> autoresVazio = new ArrayList<>();
        Livro livro = new Livro();
        autores.add(autor);
        livroService.setAutores(autores, livro);

        assertThrows(IllegalArgumentException.class, () ->
                livroService.setAutores(null, livro));

        assertThrows(IllegalArgumentException.class, () ->
                livroService.setAutores(autoresVazio, livro));
    }
}