package com.example.livraria.controller;

import com.example.livraria.dto.AluguelDto;
import com.example.livraria.dto.LivroDto;
import com.example.livraria.mocks.AluguelMock;
import com.example.livraria.mocks.AutorMock;
import com.example.livraria.mocks.LivroMock;
import com.example.livraria.mocks.LocatarioMock;
import com.example.livraria.model.Autor;
import com.example.livraria.model.Livro;
import com.example.livraria.model.Locatario;
import com.example.livraria.service.LivroService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

public class LivroControllerTest {

    @Mock
    private LivroService livroService;

    @InjectMocks
    private LivroController livroController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @DisplayName("Deve retornar ok buscar todos os livros")
    @Test
    public void deveRetornarOkBuscarTodos() {
        LivroDto livroDto = LivroMock.criarLivroDto();
        LivroDto livroDto2 = LivroMock.criarLivroDto();
        List<LivroDto> livroDtoLista = new ArrayList<>();
        livroDtoLista.add(livroDto);
        livroDtoLista.add(livroDto2);

        when(livroService.listarTodos()).thenReturn(livroDtoLista);

        ResponseEntity<List<LivroDto>> resposta = livroController.listarTodos();
        assertEquals(HttpStatus.OK, resposta.getStatusCode());
        assertEquals(2, resposta.getBody().size());
        assertEquals("Livro", resposta.getBody().get(0).getNome());
    }

    @DisplayName("Deve retornar noContent buscar todos os livros")
    @Test
    public void deveRetornarNoContentBuscarTodos() {
        List<LivroDto> livroDtoLista = new ArrayList<>();

        when(livroService.listarTodos()).thenReturn(livroDtoLista);

        ResponseEntity<List<LivroDto>> resposta = livroController.listarTodos();
        assertEquals(HttpStatus.NO_CONTENT, resposta.getStatusCode());
    }

    @DisplayName("Deve retornar ok buscar por id")
    @Test
    public void deveRetornarOkBuscarPorId() {
        LivroDto livroDto = LivroMock.criarLivroDto();
        when(livroService.buscarPorId(1L)).thenReturn(livroDto);

        ResponseEntity<LivroDto> resposta = livroController.buscarPorId(1L);

        assertEquals(HttpStatus.OK, resposta.getStatusCode());
        assertEquals(livroDto, resposta.getBody());

        verify(livroService).buscarPorId(1L);
    }

    @DisplayName("Deve retornar notFound buscar por id")
    @Test
    public void deveRetornarNotFoundBuscarPorId() {
        when(livroService.buscarPorId(1L)).thenReturn(null);

        ResponseEntity<LivroDto> resposta = livroController.buscarPorId(1L);

        assertEquals(HttpStatus.NOT_FOUND, resposta.getStatusCode());
        assertNull(resposta.getBody());

        verify(livroService).buscarPorId(1L);
    }

    @DisplayName("Deve retornar ok buscar livros por nome de autor")
    @Test
    public void deveRetornarOkBuscarLivrosPorAutor() {
        Autor autor = AutorMock.criarAutor();
        LivroDto livroDto = LivroMock.criarLivroDto();
        List<Autor> autorDtoLista = new ArrayList<>();
        autorDtoLista.add(autor);
        livroDto.setAutores(autorDtoLista);
        List<LivroDto> livroDtoLista = new ArrayList<>();
        livroDtoLista.add(livroDto);

        when(livroService.buscarPorAutor("Autor")).thenReturn(livroDtoLista);

        ResponseEntity<List<LivroDto>> resposta = livroController.buscarPorAutor("Autor");

        assertEquals(HttpStatus.OK, resposta.getStatusCode());
        assertEquals(livroDtoLista, resposta.getBody());

        verify(livroService).buscarPorAutor("Autor");
    }

    @DisplayName("Deve retornar noContent buscar livros por nome de autor")
    @Test
    public void deveRetornarNotFoundBuscarLivrosPorAutor() {
        when(livroService.buscarPorAutor("Autor")).thenReturn(Collections.emptyList());

        ResponseEntity<List<LivroDto>> resposta = livroController.buscarPorAutor("Autor");

        assertEquals(HttpStatus.NO_CONTENT, resposta.getStatusCode());
        assertNull(resposta.getBody());

        verify(livroService).buscarPorAutor("Autor");
    }

    @DisplayName("Deve retornar ok buscar livros por nome de locatario")
    @Test
    public void deveRetornarOkBuscarLivrosPorLocatario() {
        LivroDto livroDto = LivroMock.criarLivroDto();
        List<LivroDto> livroDtoLista = new ArrayList<>();
        livroDtoLista.add(livroDto);

        Locatario locatario = LocatarioMock.criarLocatario();
        AluguelDto aluguelDto = AluguelMock.criarAluguelDto();
        Livro livro = LivroMock.criarLivro();
        List<Livro> livroLista = new ArrayList<>();
        livroLista.add(livro);
        aluguelDto.setLivros(livroLista);
        aluguelDto.setLocatario(locatario);

        when(livroService.buscarPorLocatario("Locatario")).thenReturn(livroDtoLista);

        ResponseEntity<List<LivroDto>> resposta = livroController.buscarPorLocatario("Locatario");

        assertEquals(HttpStatus.OK, resposta.getStatusCode());
        assertEquals(livroDtoLista, resposta.getBody());

        verify(livroService).buscarPorLocatario("Locatario");
    }

    @DisplayName("Deve retornar noContent buscar livros por nome de locatario")
    @Test
    public void deveRetornarNotFoundBuscarLivrosPorLocatario() {
        LivroDto livroDto = LivroMock.criarLivroDto();
        List<LivroDto> livroDtoLista = new ArrayList<>();
        livroDtoLista.add(livroDto);

        when(livroService.buscarPorLocatario("Locatario")).thenReturn(Collections.emptyList());

        ResponseEntity<List<LivroDto>> resposta = livroController.buscarPorLocatario("Locatario");

        assertEquals(HttpStatus.NO_CONTENT, resposta.getStatusCode());
        assertNull(resposta.getBody());

        verify(livroService).buscarPorLocatario("Locatario");
    }

    @DisplayName("Deve retornar ok buscar livros disponiveis")
    @Test
    public void deveRetornarOkBuscarLivrosDisponiveis() {
        LivroDto livroDto = LivroMock.criarLivroDto();
        List<LivroDto> livroDtoLista = new ArrayList<>();
        livroDtoLista.add(livroDto);


        when(livroService.buscarDisponiveis()).thenReturn(livroDtoLista);

        ResponseEntity<List<LivroDto>> resposta = livroController.buscarDisponiveis();

        assertEquals(HttpStatus.OK, resposta.getStatusCode());
        assertEquals(livroDtoLista, resposta.getBody());

        verify(livroService).buscarDisponiveis();
    }

    @DisplayName("Deve retornar noContent buscar livros disponiveis")
    @Test
    public void deveRetornarNoContentBuscarLivrosDisponiveis() {
        LivroDto livroDto = LivroMock.criarLivroDto();
        livroDto.setAlugado(true);
        List<LivroDto> livroDtoLista = new ArrayList<>();
        livroDtoLista.add(livroDto);

        when(livroService.buscarDisponiveis()).thenReturn(Collections.emptyList());

        ResponseEntity<List<LivroDto>> resposta = livroController.buscarDisponiveis();

        assertEquals(HttpStatus.NO_CONTENT, resposta.getStatusCode());
        assertNull(resposta.getBody());

        verify(livroService).buscarDisponiveis();
    }

    @DisplayName("Deve retornar ok buscar livros indisponiveis")
    @Test
    public void deveRetornarOkBuscarLivrosIndisponiveis() {
        LivroDto livroDto = LivroMock.criarLivroDto();
        livroDto.setAlugado(true);
        List<LivroDto> livroDtoLista = new ArrayList<>();
        livroDtoLista.add(livroDto);


        when(livroService.buscarIndisponiveis()).thenReturn(livroDtoLista);

        ResponseEntity<List<LivroDto>> resposta = livroController.buscarIndisponiveis();

        assertEquals(HttpStatus.OK, resposta.getStatusCode());
        assertEquals(livroDtoLista, resposta.getBody());

        verify(livroService).buscarIndisponiveis();
    }

    @DisplayName("Deve retornar noContent buscar livros indisponiveis")
    @Test
    public void deveRetornarNoContentBuscarLivrosIndisponiveis() {
        LivroDto livroDto = LivroMock.criarLivroDto();
        List<LivroDto> livroDtoLista = new ArrayList<>();
        livroDtoLista.add(livroDto);

        when(livroService.buscarIndisponiveis()).thenReturn(Collections.emptyList());

        ResponseEntity<List<LivroDto>> resposta = livroController.buscarIndisponiveis();

        assertEquals(HttpStatus.NO_CONTENT, resposta.getStatusCode());
        assertNull(resposta.getBody());

        verify(livroService).buscarIndisponiveis();

    }

    @DisplayName("Deve retornar ok adicionar um livro")
    @Test
    public void deveRetornarOkAdicionarLivro() {
        LivroDto livroDto = LivroMock.criarLivroDto();

        Livro livroMock = LivroMock.criarLivro();
        when(livroService.adicionar(livroDto)).thenReturn(livroDto);

        ResponseEntity<LivroDto> resposta = livroController.adicionar(livroDto);

        assertEquals(livroMock.getNome(), resposta.getBody().getNome());
        assertEquals(livroMock.getIsbn(), resposta.getBody().getIsbn());
        assertEquals(livroMock.getDataDePublicacao(), resposta.getBody().getDataDePublicacao());
        assertEquals(HttpStatus.OK, resposta.getStatusCode());
    }

    @DisplayName("Deve retornar badRequest ao adicionar um livro")
    @Test
    public void deveRetornarBadRequestAoAdicionarLivroComIsbnNulo() {
        LivroDto livroDto = LivroMock.criarLivroDto();
        livroDto.setNome("");

        doThrow(IllegalArgumentException.class).when(livroService).adicionar(livroDto);

        ResponseEntity<LivroDto> resposta = livroController.adicionar(livroDto);

        assertEquals(HttpStatus.BAD_REQUEST, resposta.getStatusCode());
        assertNull(resposta.getBody());

        verify(livroService).adicionar(livroDto);
    }


}