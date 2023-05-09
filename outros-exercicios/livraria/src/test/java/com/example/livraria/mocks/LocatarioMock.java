package com.example.livraria.mocks;

import static com.example.livraria.model.enums.Sexo.MASCULINO;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.example.livraria.dto.LocatarioDto;
import com.example.livraria.model.Aluguel;
import com.example.livraria.model.Locatario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LocatarioMock {

    public static LocatarioDto criarLocatarioDto() {
        List<Aluguel> alugueis = new ArrayList<>();
        LocatarioDto locatarioDto = new LocatarioDto();
        locatarioDto.setNome("Locatario");
        locatarioDto.setSexo(MASCULINO);
        locatarioDto.setTelefone("11234567890");
        locatarioDto.setEmail("a@a.com");
        locatarioDto.setDataDeNascimento(LocalDate.of(2000, 1, 1));
        locatarioDto.setCpf(111222333);
        locatarioDto.setAlugeis(alugueis);
        return locatarioDto;
    }

    public static Locatario criarLocatario() {
        List<Aluguel> alugueis = new ArrayList<>();
        Locatario locatario = mock((Locatario.class));
        when(locatario.getId()).thenReturn(1L);
        when(locatario.getNome()).thenReturn("Locatario");
        when(locatario.getSexo()).thenReturn(MASCULINO);
        when(locatario.getTelefone()).thenReturn("11234567890");
        when(locatario.getEmail()).thenReturn("a@a.com");
        when(locatario.getDataDeNascimento()).thenReturn(LocalDate.of(2000, 1, 1));
        when(locatario.getCpf()).thenReturn(111222333);
        when(locatario.getAlugeis()).thenReturn(alugueis);
        return locatario;
    }
}
