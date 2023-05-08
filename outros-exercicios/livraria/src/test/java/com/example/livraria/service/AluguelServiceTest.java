package com.example.livraria.service;

import com.example.livraria.dto.AluguelDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;
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
        AluguelDto aluguelDto = new AluguelDto();
        aluguelDto.setDataRetirada(LocalDate.now());
        aluguelService.setDataRetirada(data, aluguelDto);

        assertEquals(data, aluguelDto.getDataRetirada());
    }

    @DisplayName("Deve retornar erro se a data de retirada do aluguel for nulo")
    @Test
    public void deveRetornarErroDataDeRetiradaNulo() {
        LocalDate data = LocalDate.of(1990, 5, 10);
        AluguelDto aluguelDto = new AluguelDto();
        aluguelDto.setDataRetirada(LocalDate.now());
        aluguelService.setDataRetirada(data, aluguelDto);

        assertThrows(IllegalArgumentException.class, () ->
                aluguelService.setDataRetirada(null, aluguelDto));
    }

    @DisplayName("Deve modificar a data de devolução do aluguel")
    @Test
    public void deveModificarDataDeDevolucao() {
        LocalDate data = LocalDate.of(1990, 5, 10);
        AluguelDto aluguelDto = new AluguelDto();
        aluguelDto.setDataDevolucao(LocalDate.now());
        aluguelService.setDataDevolucao(data, aluguelDto);

        assertEquals(data, aluguelDto.getDataDevolucao());
    }

    @DisplayName("Deve retornar erro se a data de devolução do aluguel for nulo")
    @Test
    public void deveRetornarErroDataDeDevolucaoNulo() {
        LocalDate data = LocalDate.of(1990, 5, 10);
        AluguelDto aluguelDto = new AluguelDto();
        aluguelDto.setDataDevolucao(LocalDate.now());
        aluguelService.setDataDevolucao(data, aluguelDto);

        assertThrows(IllegalArgumentException.class, () ->
                aluguelService.setDataDevolucao(null, aluguelDto));
    }
}