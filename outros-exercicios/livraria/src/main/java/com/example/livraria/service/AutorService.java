package com.example.livraria.service;

import com.example.livraria.dto.AutorDto;
import com.example.livraria.model.Autor;
import com.example.livraria.repository.AutorRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

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

    public AutorDto adicionar(AutorDto autorDto) {
        setNome(autorDto.getNome(), autorDto);
        setAnoDeNascimento(autorDto.getAnoDeNascimento(), autorDto);
        setcpf(autorDto.getCpf(), autorDto);

        Autor autor = new Autor();
        BeanUtils.copyProperties(autorDto, autor);
        autor = autorRepository.save(autor);
        BeanUtils.copyProperties(autor, autorDto);

        return autorDto;
    }
}
