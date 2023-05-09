package com.example.livraria.controller;

import com.example.livraria.dto.AutorDto;
import com.example.livraria.mocks.AutorMock;
import com.example.livraria.model.Autor;
import com.example.livraria.service.AutorService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

public class AutorControllerTest {

    @Mock
    private AutorService autorService;

    @InjectMocks
    private AutorController autorController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @DisplayName("Deve retornar ok buscar todos os autores")
    @Test
    public void deveRetornarOkBuscarTodos() {
        AutorDto autorDto = AutorMock.criarAutorDto();
        AutorDto autorDto2 = AutorMock.criarAutorDto();
        List<AutorDto> autorDtoLista = new ArrayList<>();
        autorDtoLista.add(autorDto);
        autorDtoLista.add(autorDto2);

        when(autorService.listarTodos()).thenReturn(autorDtoLista);

        ResponseEntity<List<AutorDto>> resposta = autorController.listarTodos();
        assertEquals(HttpStatus.OK, resposta.getStatusCode());
        assertEquals(2, resposta.getBody().size());
        assertEquals("Autor", resposta.getBody().get(0).getNome());
    }

    @DisplayName("Deve retornar noContent buscar todos os autores")
    @Test
    public void deveRetornarNoContentBuscarTodos() {
        List<AutorDto> autorDtoLista = new ArrayList<>();

        when(autorService.listarTodos()).thenReturn(autorDtoLista);

        ResponseEntity<List<AutorDto>> resposta = autorController.listarTodos();
        assertEquals(HttpStatus.NO_CONTENT, resposta.getStatusCode());
    }

    @DisplayName("Deve retornar ok buscar por id")
    @Test
    public void deveRetornarOkBuscarPorId() {
        AutorDto autorDto = AutorMock.criarAutorDto();
        when(autorService.buscarPorId(1L)).thenReturn(autorDto);

        ResponseEntity<AutorDto> resposta = autorController.buscarPorId(1L);

        assertEquals(HttpStatus.OK, resposta.getStatusCode());
        assertEquals(autorDto, resposta.getBody());

        verify(autorService).buscarPorId(1L);
    }

    @DisplayName("Deve retornar notFound buscar por id")
    @Test
    public void deveRetornarNotFoundBuscarPorId() {
        when(autorService.buscarPorId(1L)).thenReturn(null);

        ResponseEntity<AutorDto> resposta = autorController.buscarPorId(1L);

        assertEquals(HttpStatus.NOT_FOUND, resposta.getStatusCode());
        assertNull(resposta.getBody());

        verify(autorService).buscarPorId(1L);
    }

    @DisplayName("Deve retornar ok buscar por nome")
    @Test
    public void deveRetornarOkBuscarPorNome() {
        AutorDto autorDto = AutorMock.criarAutorDto();
        List<AutorDto> autorDtoLista = new ArrayList<>();
        autorDtoLista.add(autorDto);
        when(autorService.buscarPorNome("Autor")).thenReturn(autorDtoLista);

        ResponseEntity<List<AutorDto>> resposta = autorController.buscarPorNome("Autor");

        assertEquals(HttpStatus.OK, resposta.getStatusCode());
        assertEquals(autorDtoLista, resposta.getBody());

        verify(autorService).buscarPorNome("Autor");
    }

    @DisplayName("Deve retornar notFound buscar por nome")
    @Test
    public void deveRetornarNotFoundBuscarPorNome() {
        when(autorService.buscarPorNome("Autor")).thenReturn(null);

        ResponseEntity<List<AutorDto>> resposta = autorController.buscarPorNome("Autor");

        assertEquals(HttpStatus.NOT_FOUND, resposta.getStatusCode());
        assertNull(resposta.getBody());

        verify(autorService).buscarPorNome("Autor");
    }

    @DisplayName("Deve retornar ok adicionar um autor")
    @Test
    public void deveRetornarOkAdicionarAutor() {
        AutorDto autorDto = AutorMock.criarAutorDto();

        Autor autorMock = AutorMock.criarAutor();
        when(autorService.adicionar(autorDto)).thenReturn(autorDto);

        ResponseEntity<AutorDto> resposta = autorController.adicionar(autorDto);

        assertEquals(autorMock.getCpf(), resposta.getBody().getCpf());
        assertEquals(autorMock.getNome(), resposta.getBody().getNome());
        assertEquals(HttpStatus.OK, resposta.getStatusCode());
    }

    @DisplayName("Deve retornar badRequest ao adicionar um autor")
    @Test
    public void deveRetornarBadRequestAdicionarAutor() {
        AutorDto autorDto = AutorMock.criarAutorDto();
        autorDto.setCpf(-1);

        doThrow(IllegalArgumentException.class).when(autorService).adicionar(autorDto);

        ResponseEntity<AutorDto> resposta = autorController.adicionar(autorDto);

        assertEquals(HttpStatus.BAD_REQUEST, resposta.getStatusCode());
        assertNull(resposta.getBody());

        verify(autorService).adicionar(autorDto);
    }
}
