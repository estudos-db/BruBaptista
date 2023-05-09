package com.example.livraria.mocks;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.example.livraria.dto.LivroDto;
import com.example.livraria.model.Autor;
import com.example.livraria.model.Livro;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LivroMock {

    public static LivroDto criarLivroDto() {
        List<Autor> autores = new ArrayList<>();
        autores.add(AutorMock.criarAutor());
        LivroDto livroDto = new LivroDto();
        livroDto.setNome("Livro");
        livroDto.setIsbn(1234567890);
        livroDto.setDataDePublicacao(LocalDate.of(2021, 1, 1));
        livroDto.setAlugado(false);
        livroDto.setAutores(autores);
        return livroDto;
    }

    public static Livro criarLivro() {
        List<Autor> autores = new ArrayList<>();
        autores.add(AutorMock.criarAutor());
        Livro livro = mock(Livro.class);
        when(livro.getId()).thenReturn(1L);
        when(livro.getNome()).thenReturn("Livro");
        when(livro.getIsbn()).thenReturn(1234567890);
        when(livro.getDataDePublicacao()).thenReturn(LocalDate.of(2021, 1, 1));
        when(livro.isAlugado()).thenReturn(false);
        when(livro.getAutores()).thenReturn(autores);
        return livro;
    }
}
