package com.example.livraria.service;

import com.example.livraria.dto.LocatarioDto;
import com.example.livraria.model.Locatario;
import com.example.livraria.repository.LocatarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class LocatarioService {

    @Autowired
    private LocatarioRepository locatarioRepository;

    public void setNome(String nome, LocatarioDto locatarioDto) {
        if(nome == null || nome.isEmpty())
            throw new IllegalArgumentException("Nome inválido");

        locatarioDto.setNome(nome);
    }


    public void setTelefone(int ddd, int numero, LocatarioDto locatarioDto) {
        if(ddd < 10 || ddd > 99)
            throw new IllegalArgumentException("O DDD deve ter 2 dígitos");

        if(numero < 10000000 || numero > 999999999)
            throw new IllegalArgumentException("O número deve ter 8 ou 9 dígitos");

        locatarioDto.setTelefone(ddd, numero);
    }

    public void setEmail(String email, LocatarioDto locatarioDto) {
        if(email == null || !email.contains("@") || email.contains(" "))
            throw new IllegalArgumentException("Email inválido");

        locatarioDto.setEmail(email);
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento, LocatarioDto locatarioDto) {
        if(dataDeNascimento == null || dataDeNascimento.getYear() < 1900)
            throw new IllegalArgumentException("Ano de nascimento inválido");

        locatarioDto.setDataDeNascimento(dataDeNascimento);
    }

    public void setcpf(Integer cpf, LocatarioDto locatarioDto) {
        if(cpf == null || 0 >= cpf)
            throw new IllegalArgumentException("cpf inválido");

        locatarioDto.setCpf(cpf);
    }

    public LocatarioDto adicionar(LocatarioDto locatarioDto) {
        setNome(locatarioDto.getNome(), locatarioDto);
        setEmail(locatarioDto.getEmail(), locatarioDto);
        setDataDeNascimento(locatarioDto.getDataDeNascimento(), locatarioDto);
        setcpf(locatarioDto.getCpf(), locatarioDto);

        Locatario locatario = new Locatario();
        BeanUtils.copyProperties(locatarioDto, locatario);
        locatario = locatarioRepository.save(locatario);
        BeanUtils.copyProperties(locatarioDto, locatarioDto);

        return locatarioDto;
    }
}
