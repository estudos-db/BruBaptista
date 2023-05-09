package com.example.livraria.controller;

import com.example.livraria.dto.AluguelDto;
import com.example.livraria.mocks.AluguelMock;
import com.example.livraria.model.Aluguel;
import com.example.livraria.service.AluguelService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

public class AluguelControllerTest {

    @Mock
    private AluguelService aluguelService;

    @InjectMocks
    private AluguelController aluguelController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @DisplayName("Deve retornar ok buscar todos os alugueis")
    @Test
    public void deveRetornarOkBuscarTodos() {
        AluguelDto aluguelDto = AluguelMock.criarAluguelDto();
        List<AluguelDto> aluguelDtoLista = new ArrayList<>();
        aluguelDtoLista.add(aluguelDto);

        when(aluguelService.listarTodos()).thenReturn(aluguelDtoLista);

        ResponseEntity<List<AluguelDto>> resposta = aluguelController.listarTodos();
        assertEquals(HttpStatus.OK, resposta.getStatusCode());
        assertEquals(1, resposta.getBody().size());
        assertEquals(LocalDate.now(), resposta.getBody().get(0).getDataRetirada());
    }

    @DisplayName("Deve retornar noContent buscar todos os alugueis")
    @Test
    public void deveRetornarNoContentBuscarTodos() {
        List<AluguelDto> aluguelDtoLista = new ArrayList<>();

        when(aluguelService.listarTodos()).thenReturn(aluguelDtoLista);

        ResponseEntity<List<AluguelDto>> resposta = aluguelController.listarTodos();
        assertEquals(HttpStatus.NO_CONTENT, resposta.getStatusCode());
    }

    @DisplayName("Deve retornar ok buscar por id")
    @Test
    public void deveRetornarOkBuscarPorId() {
        AluguelDto aluguelDto = AluguelMock.criarAluguelDto();
        when(aluguelService.buscarPorId(1L)).thenReturn(aluguelDto);

        ResponseEntity<AluguelDto> resposta = aluguelController.buscarPorId(1L);

        assertEquals(HttpStatus.OK, resposta.getStatusCode());
        assertEquals(aluguelDto, resposta.getBody());

        verify(aluguelService).buscarPorId(1L);
    }

    @DisplayName("Deve retornar notFound buscar por id")
    @Test
    public void deveRetornarNotFoundBuscarPorId() {
        when(aluguelService.buscarPorId(1L)).thenReturn(null);

        ResponseEntity<AluguelDto> resposta = aluguelController.buscarPorId(1L);

        assertEquals(HttpStatus.NOT_FOUND, resposta.getStatusCode());
        assertNull(resposta.getBody());

        verify(aluguelService).buscarPorId(1L);
    }

    // Falta corrigir
//    @DisplayName("Deve retornar ok adicionar um aluguel")
//    @Test
//    public void deveRetornarOkAdicionarAluguel() {
//        AluguelDto aluguelDto = AluguelMock.criarAluguelDto();
//
//        Aluguel aluguelMock = AluguelMock.criarAluguel();
//        when(aluguelService.adicionar(aluguelDto)).thenReturn(aluguelDto);
//
//        ResponseEntity<AluguelDto> resposta = aluguelController.adicionar(aluguelDto);
//
//        assertEquals(aluguelMock.getDataDevolucao(), resposta.getBody().getDataDevolucao());
//        assertEquals(aluguelMock.getDataRetirada(), resposta.getBody().getDataRetirada());
//        assertEquals(HttpStatus.OK, resposta.getStatusCode());
//    }

    @DisplayName("Deve retornar badRequest ao adicionar um aluguel")
    @Test
    public void deveRetornarBadRequestAdicionarAluguel() {
        AluguelDto aluguelDto = AluguelMock.criarAluguelDto();
        aluguelDto.setId(-1);

        doThrow(IllegalArgumentException.class).when(aluguelService).adicionar(aluguelDto);

        ResponseEntity<AluguelDto> resposta = aluguelController.adicionar(aluguelDto);

        assertEquals(HttpStatus.BAD_REQUEST, resposta.getStatusCode());
        assertNull(resposta.getBody());

        verify(aluguelService).adicionar(aluguelDto);
    }
}