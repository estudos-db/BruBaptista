package com.example.livraria.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.example.livraria.dto.AutorDto;
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
        AutorDto autorDto = new AutorDto();
        autorDto.setNome("Teste");
        autorService.setNome("NovoNome", autorDto);

        assertEquals("NovoNome", autorDto.getNome());
    }

    @DisplayName("Deve retornar erro se o nome do autor for nulo ou vazio")
    @Test
    public void deveRetornarErroNomeNuloOuVazio() {
        AutorDto autorDto = new AutorDto();
        autorDto.setNome("Teste");

        assertThrows(IllegalArgumentException.class, () ->
                autorService.setNome("", autorDto));

        assertThrows(IllegalArgumentException.class, () ->
                autorService.setNome(null, autorDto));
    }

    @DisplayName("Deve modificar o ano de nascimento do autor")
    @Test
    public void deveModificarAno() {
        AutorDto autorDto = new AutorDto();
        autorDto.setAnoDeNascimento(1990);
        autorService.setAnoDeNascimento(1991, autorDto);

        assertEquals(1991, autorDto.getAnoDeNascimento());
    }

    @DisplayName("Deve retornar erro se o ano de nascimento do autor for nulo ou maior que o ano atual")
    @Test
    public void deveRetornarErroAnoNuloOuMaiorQueAtual() {
        AutorDto autorDto = new AutorDto();
        autorDto.setAnoDeNascimento(1990);

        assertThrows(IllegalArgumentException.class, () ->
                autorService.setAnoDeNascimento(3030, autorDto));

        assertThrows(IllegalArgumentException.class, () ->
                autorService.setAnoDeNascimento(null, autorDto));
    }

    @DisplayName("Deve modificar o cpf do autor")
    @Test
    public void deveModificarCpf() {
        AutorDto autorDto = new AutorDto();
        autorDto.setCpf(123456789);
        autorService.setcpf(987654321, autorDto);

        assertEquals(987654321, autorDto.getCpf());
    }

    @DisplayName("Deve retornar erro se o cpf do autor for nulo, zero ou menor")
    @Test
    public void deveRetornarErroCpfNuloZeroOuMenor() {
        AutorDto autorDto = new AutorDto();
        autorDto.setCpf(123456789);

        assertThrows(IllegalArgumentException.class, () ->
                autorService.setcpf(null, autorDto));

        assertThrows(IllegalArgumentException.class, () ->
                autorService.setcpf(0, autorDto));

        assertThrows(IllegalArgumentException.class, () ->
                autorService.setcpf(-10, autorDto));
    }
}