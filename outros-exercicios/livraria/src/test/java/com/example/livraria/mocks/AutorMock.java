package com.example.livraria.mocks;

import static com.example.livraria.model.enums.Sexo.MASCULINO;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.example.livraria.dto.AutorDto;
import com.example.livraria.model.Autor;

public class AutorMock {

    public static AutorDto criarAutorDto() {
        AutorDto autorDto = new AutorDto();
        autorDto.setNome("Autor");
        autorDto.setSexo(MASCULINO);
        autorDto.setAnoDeNascimento(1990);
        autorDto.setCpf(123456789);
        return autorDto;
    }

    public static Autor criarAutor() {
        Autor autor = mock(Autor.class);
        when(autor.getId()).thenReturn(1L);
        when(autor.getNome()).thenReturn("Autor");
        when(autor.getSexo()).thenReturn(MASCULINO);
        when(autor.getAnoDeNascimento()).thenReturn(1990);
        when(autor.getCpf()).thenReturn(123456789);
        return autor;
    }
}