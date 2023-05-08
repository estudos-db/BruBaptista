package com.example.livraria.service;

import com.example.livraria.dto.AutorDto;
import com.example.livraria.model.Autor;
import com.example.livraria.repository.AutorRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public void setNome(String nome, AutorDto autorDto) {
        if(nome == null || nome.isEmpty())
            throw new IllegalArgumentException("Nome inválido");

        autorDto.setNome(nome);
    }

    public void setAnoDeNascimento(Integer anoDeNascimento, AutorDto autorDto) {
        if(anoDeNascimento == null || anoDeNascimento > LocalDate.now().getYear())
            throw new IllegalArgumentException("Ano de nascimento inválido");

        autorDto.setAnoDeNascimento(anoDeNascimento);
    }

    public void setcpf(Integer cpf, AutorDto autorDto) {
        if(cpf == null || cpf <= 0)
            throw new IllegalArgumentException("CPF inválido");

        autorDto.setCpf(cpf);
    }

//    public void setLivros(List<Livro> livros, AutorDto autorDto) {
//        autorDto.setLivros(livros);
//    }

    public AutorDto criar(AutorDto autorDto) {
        setNome(autorDto.getNome(), autorDto);
        setAnoDeNascimento(autorDto.getAnoDeNascimento(), autorDto);
        setcpf(autorDto.getCpf(), autorDto);
        //setLivros(autorDto.getLivros(), autorDto);

        Autor autor = new Autor();
        BeanUtils.copyProperties(autorDto, autor);
        autor = autorRepository.save(autor);
        BeanUtils.copyProperties(autor, autorDto);

        return autorDto;
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
            //autorDto.setLivros(autor.getLivros());
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
            //autorDto.setLivros(autor.getLivros());
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
            //autorDto.setLivros(autor.getLivros());
            autorDtoLista.add(autorDto);
        }
        return autorDtoLista;
    }

    public AutorDto adicionar(@RequestBody AutorDto autorDto) {
        Autor autor = new Autor();
        autor.setNome(autorDto.getNome());
        autor.setSexo(autorDto.getSexo());
        autor.setAnoDeNascimento(autorDto.getAnoDeNascimento());
        autor.setCpf(autorDto.getCpf());
        //autor.setLivros(autorDto.getLivros());

        Autor novoAutor = autorRepository.save(autor);
        AutorDto novoAutorDto = new AutorDto();
        novoAutorDto.setId(novoAutor.getId());
        novoAutorDto.setNome(novoAutor.getNome());
        novoAutorDto.setSexo(novoAutor.getSexo());
        novoAutorDto.setAnoDeNascimento(novoAutor.getAnoDeNascimento());
        novoAutorDto.setCpf(novoAutor.getCpf());
        //novoAutorDto.setLivros(novoAutor.getLivros());

        return novoAutorDto;
    }

    public void deletarPorId(Long id) {
        Optional<Autor> autorOptional = autorRepository.findById(id);
        if(autorOptional.isPresent())
            autorRepository.deleteById(id);
        else
         throw new IllegalArgumentException("Autor não encontrado");
    }

    public AutorDto atualizar(Long id, AutorDto autorDto) {
        Optional<Autor> autorOptional = autorRepository.findById(id);
        if(autorOptional.isPresent()) {
            Autor autor = autorOptional.get();
            autor.setNome(autorDto.getNome());
            autor.setSexo(autorDto.getSexo());
            autor.setAnoDeNascimento(autorDto.getAnoDeNascimento());
            autor.setCpf(autorDto.getCpf());
            //autor.setLivros(autorDto.getLivros());

            Autor autorAtualizado = autorRepository.save(autor);
            AutorDto autorAtualizadoDto = new AutorDto();
            autorAtualizadoDto.setId(autorAtualizado.getId());
            autorAtualizadoDto.setNome(autorAtualizado.getNome());
            autorAtualizadoDto.setSexo(autorAtualizado.getSexo());
            autorAtualizadoDto.setAnoDeNascimento(autorAtualizado.getAnoDeNascimento());
            autorAtualizadoDto.setCpf(autorAtualizado.getCpf());
            //autorAtualizadoDto.setLivros(autorAtualizado.getLivros());

            return autorAtualizadoDto;
        } else
            throw new IllegalArgumentException("Autor não encontrado");
    }
}