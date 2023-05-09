package com.example.livraria.controller;

import com.example.livraria.dto.LocatarioDto;
import com.example.livraria.mocks.LocatarioMock;
import com.example.livraria.model.Locatario;
import com.example.livraria.service.LocatarioService;
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

public class LocatarioControllerTest {

    @Mock
    private LocatarioService locatarioService;

    @InjectMocks
    private LocatarioController locatarioController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @DisplayName("Deve retornar ok buscar todos os locatarios")
    @Test
    public void deveRetornarOkBuscarTodos() {
        LocatarioDto locatarioDto = LocatarioMock.criarLocatarioDto();
        LocatarioDto locatarioDto2 = LocatarioMock.criarLocatarioDto();
        List<LocatarioDto> locatarioDtoLista = new ArrayList<>();
        locatarioDtoLista.add(locatarioDto);
        locatarioDtoLista.add(locatarioDto2);

        when(locatarioService.listarTodos()).thenReturn(locatarioDtoLista);

        ResponseEntity<List<LocatarioDto>> resposta = locatarioController.listarTodos();
        assertEquals(HttpStatus.OK, resposta.getStatusCode());
        assertEquals(2, resposta.getBody().size());
        assertEquals("Locatario", resposta.getBody().get(0).getNome());
    }

    @DisplayName("Deve retornar noContent buscar todos os locatarios")
    @Test
    public void deveRetornarNoContentBuscarTodos() {
        List<LocatarioDto> locatarioDtoLista = new ArrayList<>();

        when(locatarioService.listarTodos()).thenReturn(locatarioDtoLista);

        ResponseEntity<List<LocatarioDto>> resposta = locatarioController.listarTodos();
        assertEquals(HttpStatus.NO_CONTENT, resposta.getStatusCode());
    }

    @DisplayName("Deve retornar ok buscar por id")
    @Test
    public void deveRetornarOkBuscarPorId() {
        LocatarioDto locatarioDto = LocatarioMock.criarLocatarioDto();
        when(locatarioService.buscarPorId(1L)).thenReturn(locatarioDto);

        ResponseEntity<LocatarioDto> resposta = locatarioController.buscarPorId(1L);

        assertEquals(HttpStatus.OK, resposta.getStatusCode());
        assertEquals(locatarioDto, resposta.getBody());

        verify(locatarioService).buscarPorId(1L);
    }

    @DisplayName("Deve retornar notFound buscar por id")
    @Test
    public void deveRetornarNotFoundBuscarPorId() {
        when(locatarioService.buscarPorId(1L)).thenReturn(null);

        ResponseEntity<LocatarioDto> resposta = locatarioController.buscarPorId(1L);

        assertEquals(HttpStatus.NOT_FOUND, resposta.getStatusCode());
        assertNull(resposta.getBody());

        verify(locatarioService).buscarPorId(1L);
    }

    @DisplayName("Deve retornar ok adicionar um locatario")
    @Test
    public void deveRetornarOkAdicionarLocatario() {
        LocatarioDto locatarioDto = LocatarioMock.criarLocatarioDto();

        Locatario locatarioMock = LocatarioMock.criarLocatario();
        when(locatarioService.adicionar(locatarioDto)).thenReturn(locatarioDto);

        ResponseEntity<LocatarioDto> resposta = locatarioController.adicionar(locatarioDto);

        assertEquals(locatarioMock.getNome(), resposta.getBody().getNome());
        assertEquals(locatarioMock.getCpf(), resposta.getBody().getCpf());
        assertEquals(HttpStatus.OK, resposta.getStatusCode());
    }

    @DisplayName("Deve retornar badRequest ao adicionar um locatario")
    @Test
    public void deveRetornarBadRequestAdicionarLocatario() {
        LocatarioDto locatarioDto = LocatarioMock.criarLocatarioDto();
        locatarioDto.setNome("");

        doThrow(IllegalArgumentException.class).when(locatarioService).adicionar(locatarioDto);

        ResponseEntity<LocatarioDto> resposta = locatarioController.adicionar(locatarioDto);

        assertEquals(HttpStatus.BAD_REQUEST, resposta.getStatusCode());
        assertNull(resposta.getBody());

        verify(locatarioService).adicionar(locatarioDto);
    }
}