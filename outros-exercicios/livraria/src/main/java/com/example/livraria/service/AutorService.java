package com.example.livraria.service;

import com.example.livraria.dto.AutorDto;
import com.example.livraria.exception.AutorComLivroException;
import com.example.livraria.exception.AutorDuplicadoException;
import com.example.livraria.exception.AutorNaoEncontradoException;
import com.example.livraria.model.Autor;
import com.example.livraria.model.Livro;
import com.example.livraria.repository.AutorRepository;
import com.example.livraria.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private LivroRepository livroRepository;

    public void setNome(String nome, Autor autor) {
        if(nome == null || nome.isEmpty())
            throw new IllegalArgumentException("Nome inválido");

        autor.setNome(nome);
    }

    public void setAnoDeNascimento(Integer anoDeNascimento, Autor autor) {
        if(anoDeNascimento == null || anoDeNascimento > LocalDate.now().getYear())
            throw new IllegalArgumentException("Ano de nascimento inválido");

        autor.setAnoDeNascimento(anoDeNascimento);
    }

    public void setcpf(Integer cpf, Autor autor) {
        if(cpf == null || cpf <= 0)
            throw new IllegalArgumentException("CPF inválido");

        autor.setCpf(cpf);
    }

    public List<AutorDto> listarTodos() {
        List<Autor> autorLista = autorRepository.findAll();
        List<AutorDto> autorDtoLista = new ArrayList<>();
        for(Autor autor : autorLista) {
            AutorDto autorDto = new AutorDto();
            autorDto.setId(autor.getId());
            autorDto.setNome(autor.getNome());
            autorDto.setSexo(autor.getSexo());
            autorDto.setAnoDeNascimento(autor.getAnoDeNascimento());
            autorDto.setCpf(autor.getCpf());
            autorDtoLista.add(autorDto);
        }
        return autorDtoLista;
    }

    public AutorDto buscarPorId(Long id) {
        Optional<Autor> autorOptional = autorRepository.findById(id);
        if(autorOptional.isPresent()) {
            Autor autor = autorOptional.get();
            AutorDto autorDto = new AutorDto();
            autorDto.setId(autor.getId());
            autorDto.setNome(autor.getNome());
            autorDto.setSexo(autor.getSexo());
            autorDto.setAnoDeNascimento(autor.getAnoDeNascimento());
            autorDto.setCpf(autor.getCpf());
            return autorDto;
        } else
            throw new IllegalArgumentException("Autor não encontrado");
    }

    public List<AutorDto> buscarPorNome(String nome) {
        List<Autor> autorLista = autorRepository.findByNome(nome);
        List<AutorDto> autorDtoLista = new ArrayList<>();
        for(Autor autor : autorLista) {
            AutorDto autorDto = new AutorDto();
            autorDto.setId(autor.getId());
            autorDto.setNome(autor.getNome());
            autorDto.setSexo(autor.getSexo());
            autorDto.setAnoDeNascimento(autor.getAnoDeNascimento());
            autorDto.setCpf(autor.getCpf());
            autorDtoLista.add(autorDto);
        }
        return autorDtoLista;
    }

    public AutorDto adicionar(AutorDto autorDto) {

        Autor autor = new Autor();
        setNome(autorDto.getNome(), autor);
        autor.setSexo(autorDto.getSexo());
        setAnoDeNascimento(autorDto.getAnoDeNascimento(), autor);
        setcpf(autorDto.getCpf(), autor);

        Autor novoAutor = autorRepository.save(autor);

        AutorDto novoAutorDto = new AutorDto();
        novoAutorDto.setId(novoAutor.getId());
        novoAutorDto.setNome(novoAutor.getNome());
        novoAutorDto.setSexo(novoAutor.getSexo());
        novoAutorDto.setAnoDeNascimento(novoAutor.getAnoDeNascimento());
        novoAutorDto.setCpf(novoAutor.getCpf());

        return novoAutorDto;
    }

    public void deletarPorId(Long id) {
        Optional<Autor> autorOptional = autorRepository.findById(id);
        if(!autorOptional.isPresent())
            throw new AutorNaoEncontradoException("Autor não encontrado");

        boolean encontrado = false;
        List<Livro> livroLista = livroRepository.findAll();
        for(Livro livro : livroLista) {
            for(Autor autor : livro.getAutores())
                if(Objects.equals(autor.getId(), id)) {
                    encontrado = true;
                    break;
                }
            if(encontrado) break;
        }

        if(encontrado)
            throw new AutorComLivroException("O autor contém algum livro e não pode ser deletado");

        autorRepository.deleteById(id);
    }

    public AutorDto atualizar(Long id, AutorDto autorDto) {
        Optional<Autor> autorOptional = autorRepository.findById(id);
        if(autorOptional.isPresent()) {
            Autor autor = autorOptional.get();
            setNome(autorDto.getNome(), autor);
            autor.setSexo(autorDto.getSexo());
            setAnoDeNascimento(autorDto.getAnoDeNascimento(), autor);
            setcpf(autorDto.getCpf(), autor);

            Autor autorAtualizado = autorRepository.save(autor);
            AutorDto autorAtualizadoDto = new AutorDto();
            autorAtualizadoDto.setId(autorAtualizado.getId());
            autorAtualizadoDto.setNome(autorAtualizado.getNome());
            autorAtualizadoDto.setSexo(autorAtualizado.getSexo());
            autorAtualizadoDto.setAnoDeNascimento(autorAtualizado.getAnoDeNascimento());
            autorAtualizadoDto.setCpf(autorAtualizado.getCpf());

            return autorAtualizadoDto;
        } else
            throw new IllegalArgumentException("Autor não encontrado");
    }
}