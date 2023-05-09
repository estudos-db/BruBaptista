package com.example.livraria.mocks;

import static org.mockito.Mockito.when;

import com.example.livraria.dto.AluguelDto;

import com.example.livraria.model.Aluguel;
import com.example.livraria.model.Livro;
import com.example.livraria.model.Locatario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AluguelMock {

    public static AluguelDto criarAluguelDto() {
        List<Livro> livros = new ArrayList<>();
        Livro livro = LivroMock.criarLivro();
        livros.add(livro);
        Locatario locatario = LocatarioMock.criarLocatario();
        AluguelDto aluguelDto = new AluguelDto();
        aluguelDto.setLocatario(locatario);
        aluguelDto.setLivros(livros);
        aluguelDto.setDataRetirada(LocalDate.now());
        aluguelDto.setDataDevolucao(LocalDate.now().plusDays(2));
        return aluguelDto;
    }

    public static Aluguel criarAluguel() {
        List<Livro> livros = new ArrayList<>();
        Livro livro = LivroMock.criarLivro();
        livros.add(livro);
        Locatario locatario = LocatarioMock.criarLocatario();
        Aluguel aluguel = new Aluguel();
        when(aluguel.getId()).thenReturn(1L);
        when(aluguel.getLocatario()).thenReturn(locatario);
        when(aluguel.getLivros()).thenReturn(livros);
        when(aluguel.getDataRetirada()).thenReturn(LocalDate.now());
        when(aluguel.getDataDevolucao()).thenReturn(LocalDate.now().plusDays(2));
        return aluguel;
    }
}
