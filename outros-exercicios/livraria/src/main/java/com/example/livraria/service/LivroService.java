package com.example.livraria.service;

import com.example.livraria.dto.LivroDto;
import com.example.livraria.exception.LivroAlugadoException;
import com.example.livraria.exception.LivroNaoEncontradoException;
import com.example.livraria.model.Aluguel;
import com.example.livraria.model.Autor;
import com.example.livraria.model.Livro;
import com.example.livraria.repository.LivroRepository;
import com.example.livraria.repository.AutorRepository;
import com.example.livraria.repository.AluguelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private AluguelRepository aluguelRepository;

    public void setNome(String nome, Livro livro) {
        if(nome == null || nome.isEmpty())
            throw new IllegalArgumentException("Nome inválido");

        livro.setNome(nome);
    }

    public void setIsbn(Integer isbn, Livro livro) {
        if(isbn == null || isbn <= 0)
            throw new IllegalArgumentException("isbn inválido");

        livro.setIsbn(isbn);
    }

    public void setAutores(List<Autor> autores, Livro livro) {
        if(autores == null || autores.isEmpty())
            throw new IllegalArgumentException("Lista de autores inválida");
        else
            livro.setAutores(autores);
    }

    public void setDataDePublicacao(LocalDate dataDePublicacao, Livro livro) {
        if(dataDePublicacao == null)
            throw new IllegalArgumentException("Data de publicação inválida");

        livro.setDataDePublicacao(dataDePublicacao);
    }

    public List<LivroDto> listarTodos() {
        List<Livro> livroLista = livroRepository.findAll();
        List<LivroDto> livroDtoLista = new ArrayList<>();
        for(Livro livro : livroLista) {
            LivroDto livroDto = new LivroDto();
            livroDto.setId(livro.getId());
            livroDto.setNome(livro.getNome());
            livroDto.setIsbn(livro.getIsbn());
            livroDto.setAlugado(livro.isAlugado());
            livroDto.setAutores(livro.getAutores());
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
            livroDto.setAlugado(livro.isAlugado());
            livroDto.setAutores(livro.getAutores());
            livroDto.setDataDePublicacao(livro.getDataDePublicacao());
            return livroDto;
        } else
            throw new IllegalArgumentException("Livro não encontrado");
    }

    public List<LivroDto> buscarPorAutor(String nome) {
        List<LivroDto> livrosAutor = new ArrayList<>();
        List<LivroDto> livroLista = listarTodos();
        for(LivroDto livroDto : livroLista)
            for(Autor autor : livroDto.getAutores())
                if(Objects.equals(autor.getNome(), nome))
                    livrosAutor.add(livroDto);
        return livrosAutor;
    }

    public List<LivroDto> buscarPorLocatario(String nome) {
        List<LivroDto> livrosLocatario = new ArrayList<>();
        List<Aluguel> aluguelLista = aluguelRepository.findAll();
        for(Aluguel aluguel : aluguelLista)
            if(Objects.equals(aluguel.getLocatario().getNome(), nome))
                for(Livro livro : aluguel.getLivros()) {
                    LivroDto livroDto = new LivroDto();
                    livroDto.setId(livro.getId());
                    livroDto.setNome(livro.getNome());
                    livroDto.setIsbn(livro.getIsbn());
                    livroDto.setAlugado(livro.isAlugado());
                    livroDto.setAutores(livro.getAutores());
                    livroDto.setDataDePublicacao(livro.getDataDePublicacao());
                    livrosLocatario.add(livroDto);
                }
        return livrosLocatario;
    }

    public List<LivroDto> buscarDisponiveis() {
        List<Livro> livroLista = livroRepository.findAll();
        List<LivroDto> livroDtoLista = new ArrayList<>();
        for(Livro livro : livroLista)
            if(!livro.isAlugado()) {
                LivroDto livroDto = new LivroDto();
                livroDto.setId(livro.getId());
                livroDto.setNome(livro.getNome());
                livroDto.setIsbn(livro.getIsbn());
                livroDto.setAlugado(livro.isAlugado());
                livroDto.setAutores(livro.getAutores());
                livroDto.setDataDePublicacao(livro.getDataDePublicacao());
                livroDtoLista.add(livroDto);
            }
        return livroDtoLista;
    }

    public List<LivroDto> buscarIndisponiveis() {
        List<Livro> livroLista = livroRepository.findAll();
        List<LivroDto> livroDtoLista = new ArrayList<>();
        for(Livro livro : livroLista)
            if(livro.isAlugado()) {
                LivroDto livroDto = new LivroDto();
                livroDto.setId(livro.getId());
                livroDto.setNome(livro.getNome());
                livroDto.setIsbn(livro.getIsbn());
                livroDto.setAlugado(livro.isAlugado());
                livroDto.setAutores(livro.getAutores());
                livroDto.setDataDePublicacao(livro.getDataDePublicacao());
                livroDtoLista.add(livroDto);
            }
        return livroDtoLista;
    }

    public LivroDto adicionar(LivroDto livroDto) {
        Livro livro = new Livro();
        setNome(livroDto.getNome(), livro);
        setIsbn(livroDto.getIsbn(), livro);
        setAutores(livroDto.getAutores(), livro);
        setDataDePublicacao(livroDto.getDataDePublicacao(), livro);

        Livro novoLivro = livroRepository.save(livro);
        LivroDto novoLivroDto = new LivroDto();
        novoLivroDto.setId(novoLivro.getId());
        novoLivroDto.setNome(novoLivro.getNome());
        novoLivroDto.setIsbn(novoLivro.getIsbn());
        novoLivroDto.setAutores(novoLivro.getAutores());
        novoLivroDto.setDataDePublicacao(novoLivro.getDataDePublicacao());

        return novoLivroDto;
    }

    public void deletarPorId(Long id) {
        Optional<Livro> livroOptional = livroRepository.findById(id);
        if(!livroOptional.isPresent())
            throw new LivroNaoEncontradoException("Livro não encontrado");

        if(livroOptional.get().isAlugado())
            throw new LivroAlugadoException("O livro está alugado e não pode ser deletado");

        livroRepository.deleteById(id);
    }

    public LivroDto atualizar(Long id, LivroDto livroDto) {
        Optional<Livro> livroOptional = livroRepository.findById(id);
        if(livroOptional.isPresent()) {
            Livro livro = livroOptional.get();
            livro.setAlugado(livroDto.isAlugado());
            setNome(livroDto.getNome(), livro);
            setIsbn(livroDto.getIsbn(), livro);
            setAutores(livroDto.getAutores(), livro);
            setDataDePublicacao(livroDto.getDataDePublicacao(), livro);

            Livro livroAtualizado = livroRepository.save(livro);
            LivroDto livroAtualizadoDto = new LivroDto();
            livroAtualizadoDto.setId(livroAtualizado.getId());
            livroAtualizadoDto.setNome(livroAtualizado.getNome());
            livroAtualizadoDto.setIsbn(livroAtualizado.getIsbn());
            livroAtualizadoDto.setAlugado(livroAtualizado.isAlugado());
            livroAtualizadoDto.setAutores(livroAtualizado.getAutores());
            livroAtualizadoDto.setDataDePublicacao(livroAtualizado.getDataDePublicacao());

            return livroAtualizadoDto;
        } else
            throw new IllegalArgumentException("Livro não encontrado");
    }
}
