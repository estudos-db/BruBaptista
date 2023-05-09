package com.example.livraria.service;

import com.example.livraria.model.Aluguel;
import com.example.livraria.model.Livro;
import com.example.livraria.model.Locatario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
class AluguelServiceTest {

    @InjectMocks
    AluguelService aluguelService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @DisplayName("Deve modificar a data de retirada do aluguel")
    @Test
    public void deveModificarDataDeRetirada() {
        LocalDate data = LocalDate.of(1990, 5, 10);
        Aluguel aluguel = new Aluguel();
        aluguel.setDataRetirada(LocalDate.now());
        aluguelService.setDataRetirada(data, aluguel);

        assertEquals(data, aluguel.getDataRetirada());
    }

    @DisplayName("Deve retornar erro se a data de retirada do aluguel for nulo")
    @Test
    public void deveRetornarErroDataDeRetiradaNulo() {
        LocalDate data = LocalDate.of(1990, 5, 10);
        Aluguel aluguel = new Aluguel();
        aluguel.setDataRetirada(LocalDate.now());
        aluguelService.setDataRetirada(data, aluguel);

        assertThrows(IllegalArgumentException.class, () ->
                aluguelService.setDataRetirada(null, aluguel));
    }

    @DisplayName("Deve modificar a data de devolução do aluguel")
    @Test
    public void deveModificarDataDeDevolucao() {
        LocalDate data = LocalDate.of(1990, 5, 10);
        Aluguel aluguel = new Aluguel();
        aluguel.setDataDevolucao(LocalDate.now());
        aluguelService.setDataDevolucao(data, aluguel);

        assertEquals(data, aluguel.getDataDevolucao());
    }

    @DisplayName("Deve retornar erro se a data de devolução do aluguel for nulo")
    @Test
    public void deveRetornarErroDataDeDevolucaoNulo() {
        LocalDate data = LocalDate.of(1990, 5, 10);
        Aluguel aluguel = new Aluguel();
        aluguel.setDataDevolucao(LocalDate.now());
        aluguelService.setDataDevolucao(data, aluguel);

        assertThrows(IllegalArgumentException.class, () ->
                aluguelService.setDataDevolucao(null, aluguel));
    }

    @DisplayName("Deve modificar o locatario do aluguel")
    @Test
    public void deveModificarLocatario() {
        Aluguel aluguel = new Aluguel();
        Locatario locatario = new Locatario();
        aluguelService.setLocatario(locatario, aluguel);

        assertEquals(locatario, aluguel.getLocatario());
    }

    @DisplayName("Deve retornar erro se o locatario do aluguel for nulo")
    @Test
    public void deveRetornarErroLocatarioNulo() {
        Aluguel aluguel = new Aluguel();
        Locatario locatario = new Locatario();
        aluguelService.setLocatario(locatario, aluguel);

        assertThrows(IllegalArgumentException.class, () ->
                aluguelService.setLocatario(null, aluguel));
    }

    @DisplayName("Deve modificar os livros do aluguel")
    @Test
    public void deveModificarLivros() {
        Aluguel aluguel = new Aluguel();
        List<Livro> livros = new ArrayList<>();
        Livro livro = new Livro();
        livros.add(livro);
        aluguelService.setLivros(livros, aluguel);

        assertEquals(livros, aluguel.getLivros());
    }

    @DisplayName("Deve retornar erro se os livros do aluguel forem nulo ou vazio")
    @Test
    public void deveRetornarErroLivrosNuloOuVazio() {
        Aluguel aluguel = new Aluguel();
        List<Livro> livros = new ArrayList<>();
        List<Livro> livrosVazio = new ArrayList<>();
        Livro livro = new Livro();
        livros.add(livro);
        aluguelService.setLivros(livros, aluguel);

        assertThrows(IllegalArgumentException.class, () ->
                aluguelService.setLivros(null, aluguel));

        assertThrows(IllegalArgumentException.class, () ->
                aluguelService.setLivros(livrosVazio, aluguel));
    }
}