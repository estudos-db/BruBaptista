package com.example.livraria.service;

import com.example.livraria.dto.LivroDto;
import com.example.livraria.model.Livro;
import com.example.livraria.repository.LivroRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public void setNome(String nome, LivroDto livroDto) {
        if(nome == null || nome.isEmpty())
            throw new IllegalArgumentException("Nome inválido");

        livroDto.setNome(nome);
    }

    public void setisbn(Integer isbn, LivroDto livroDto) {
        if(isbn == null || isbn <= 0)
            throw new IllegalArgumentException("isbn inválido");

        livroDto.setIsbn(isbn);
    }

    public void setDataDePublicacao(LocalDate dataDePublicacao, LivroDto livroDto) {
        if(dataDePublicacao == null)
            throw new IllegalArgumentException("Data de publicação inválida");

        livroDto.setDataDePublicacao(dataDePublicacao);
    }

    public LivroDto adicionar(LivroDto livroDto) {
        setNome(livroDto.getNome(), livroDto);
        setisbn(livroDto.getIsbn(), livroDto);
        setDataDePublicacao(livroDto.getDataDePublicacao(), livroDto);

        Livro livro = new Livro();
        BeanUtils.copyProperties(livroDto, livro);
        livro = livroRepository.save(livro);
        BeanUtils.copyProperties(livro, livroDto);

        return livroDto;
    }
}
