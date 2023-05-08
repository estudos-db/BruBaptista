package com.example.livraria.service;

import com.example.livraria.dto.LivroDto;
import com.example.livraria.model.Livro;
import com.example.livraria.repository.LivroRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public void setNome(String nome, LivroDto livroDto) {
        if(nome == null || nome.isEmpty())
            throw new IllegalArgumentException("Nome inválido");

        livroDto.setNome(nome);
    }

    public void setIsbn(Integer isbn, LivroDto livroDto) {
        if(isbn == null || isbn <= 0)
            throw new IllegalArgumentException("isbn inválido");

        livroDto.setIsbn(isbn);
    }

//    public void setAutores(List<Autor> autores, LivroDto livroDto) {
//        if(autores == null || autores.isEmpty())
//            throw new IllegalArgumentException("Lista de autores inválida");
//
//        livroDto.setAutores(autores);
//    }

    public void setDataDePublicacao(LocalDate dataDePublicacao, LivroDto livroDto) {
        if(dataDePublicacao == null)
            throw new IllegalArgumentException("Data de publicação inválida");

        livroDto.setDataDePublicacao(dataDePublicacao);
    }

    public LivroDto criar(LivroDto livroDto) {
        setNome(livroDto.getNome(), livroDto);
        setIsbn(livroDto.getIsbn(), livroDto);
        //setAutores(livroDto.getAutores(), livroDto);
        setDataDePublicacao(livroDto.getDataDePublicacao(), livroDto);

        Livro livro = new Livro();
        BeanUtils.copyProperties(livroDto, livro);
        livro = livroRepository.save(livro);
        BeanUtils.copyProperties(livro, livroDto);

        return livroDto;
    }

    public List<LivroDto> listarTodos() {
        List<Livro> livroLista = livroRepository.findAll();
        List<LivroDto> livroDtoLista = new ArrayList<>();
        for(Livro livro : livroLista) {
            LivroDto livroDto = new LivroDto();
            livroDto.setId(livro.getId());
            livroDto.setNome(livro.getNome());
            livroDto.setIsbn(livro.getIsbn());
            //livroDto.setAutores(livro.getAutores());
            livroDto.setDataDePublicacao(livro.getDataDePublicacao());
            livroDtoLista.add(livroDto);
        }
        return livroDtoLista;
    }

    public LivroDto buscarPorId(Long id) {
        Optional<Livro> livroOptional = livroRepository.findById(id);
        if(livroOptional.isPresent()) {
            Livro livro = livroOptional.get();
            LivroDto livroDto = new LivroDto();
            livroDto.setId(livro.getId());
            livroDto.setNome(livro.getNome());
            livroDto.setIsbn(livro.getIsbn());
            //livroDto.setAutores(livro.getAutores());
            livroDto.setDataDePublicacao(livro.getDataDePublicacao());
            return livroDto;
        } else
            throw new IllegalArgumentException("Livro não encontrado");
    }

//    public List<LivroDto> buscarPorAutor(String nome) {
//        List<Livro> livroLista = livroRepository.buscarPorAutor(nome);
//        List<LivroDto> livroDtoLista = new ArrayList<>();
//        for(Livro livro : livroLista) {
//            LivroDto livroDto = new LivroDto();
//            livroDto.setId(livro.getId());
//            livroDto.setNome(livro.getNome());
//            livroDto.setIsbn(livro.getIsbn());
//            livroDto.setAutores(livro.getAutores());
//            livroDto.setDataDePublicacao(livro.getDataDePublicacao());
//            livroDtoLista.add(livroDto);
//        }
//        return livroDtoLista;
//    }

    public LivroDto adicionar(@RequestBody LivroDto livroDto) {
        Livro livro = new Livro();
        livro.setNome(livroDto.getNome());
        livro.setIsbn(livroDto.getIsbn());
        //livro.setAutores(livroDto.getAutores());
        livro.setDataDePublicacao(livroDto.getDataDePublicacao());

        Livro novoLivro = livroRepository.save(livro);
        LivroDto novoLivroDto = new LivroDto();
        novoLivroDto.setId(novoLivro.getId());
        novoLivroDto.setNome(novoLivro.getNome());
        novoLivroDto.setIsbn(novoLivro.getIsbn());
        //novoLivroDto.setAutores(novoLivro.getAutores());
        novoLivroDto.setDataDePublicacao(novoLivro.getDataDePublicacao());

        return novoLivroDto;
    }

    public void deletarPorId(Long id) {
        Optional<Livro> livroOptional = livroRepository.findById(id);
        if(livroOptional.isPresent())
            livroRepository.deleteById(id);
        else
            throw new IllegalArgumentException("Livro não encontrado");
    }

    public LivroDto atualizar(Long id, LivroDto livroDto) {
        Optional<Livro> livroOptional = livroRepository.findById(id);
        if(livroOptional.isPresent()) {
            Livro livro = livroOptional.get();
            livro.setNome(livroDto.getNome());
            livro.setIsbn(livroDto.getIsbn());
            //livro.setAutores(livroDto.getAutores());
            livro.setDataDePublicacao(livroDto.getDataDePublicacao());

            Livro livroAtualizado = livroRepository.save(livro);
            LivroDto livroAtualizadoDto = new LivroDto();
            livroAtualizadoDto.setId(livroAtualizado.getId());
            livroAtualizadoDto.setNome(livroAtualizado.getNome());
            livroAtualizadoDto.setIsbn(livroAtualizado.getIsbn());
            //livroAtualizadoDto.setAutores(livroAtualizado.getAutores());
            livroAtualizadoDto.setDataDePublicacao(livroAtualizado.getDataDePublicacao());

            return livroAtualizadoDto;
        } else
            throw new IllegalArgumentException("Livro não encontrado");
    }
}
