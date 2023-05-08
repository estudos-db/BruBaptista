package com.example.livraria.service;

import com.example.livraria.dto.LocatarioDto;
import com.example.livraria.model.Locatario;
import com.example.livraria.repository.LocatarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public LocatarioDto criar(LocatarioDto locatarioDto) {
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

    public List<LocatarioDto> listarTodos() {
        List<Locatario> locatarioLista = locatarioRepository.findAll();
        List<LocatarioDto> locatarioDtoLista = new ArrayList<>();
        for(Locatario locatario : locatarioLista) {
            LocatarioDto locatarioDto = new LocatarioDto();
            locatarioDto.setId(locatario.getId());
            locatarioDto.setNome(locatario.getNome());
            locatarioDto.setSexo(locatario.getSexo());
            locatarioDto.setTelefone(locatario.getTelefone());
            locatarioDto.setEmail(locatario.getEmail());
            locatarioDto.setDataDeNascimento(locatario.getDataDeNascimento());
            locatarioDto.setCpf(locatario.getCpf());
            locatarioDtoLista.add(locatarioDto);
        }
        return locatarioDtoLista;
    }

    public LocatarioDto buscarPorId(Long id) {
        Optional<Locatario> locatarioOptional = locatarioRepository.findById(id);
        if(locatarioOptional.isPresent()) {
            Locatario locatario = locatarioOptional.get();
            LocatarioDto locatarioDto = new LocatarioDto();
            locatarioDto.setId(locatario.getId());
            locatarioDto.setNome(locatario.getNome());
            locatarioDto.setSexo(locatario.getSexo());
            locatarioDto.setTelefone(locatario.getTelefone());
            locatarioDto.setEmail(locatario.getEmail());
            locatarioDto.setDataDeNascimento(locatario.getDataDeNascimento());
            locatarioDto.setCpf(locatario.getCpf());
            return locatarioDto;
        } else
            throw new IllegalArgumentException("Locatario não encontrado");
    }

    public LocatarioDto adicionar(@RequestBody LocatarioDto locatarioDto) {
        if(locatarioDto.getTelefone() == null ||
                (12 <= locatarioDto.getTelefone().length() && locatarioDto.getTelefone().length() >= 13) ||
                (!locatarioDto.getTelefone().contains("(") && !locatarioDto.getTelefone().contains(")")))
            throw new IllegalArgumentException("Telefone inválido");

        Locatario locatario = new Locatario();
        locatario.setNome(locatarioDto.getNome());
        locatario.setSexo(locatarioDto.getSexo());
        System.out.println(locatarioDto.getTelefone());
        locatario.setTelefone(locatarioDto.getTelefone());
        locatario.setEmail(locatarioDto.getEmail());
        locatario.setDataDeNascimento(locatarioDto.getDataDeNascimento());
        locatario.setCpf(locatarioDto.getCpf());

        Locatario novoLocatario = locatarioRepository.save(locatario);
        LocatarioDto novoLocatarioDto = new LocatarioDto();
        novoLocatarioDto.setId(novoLocatario.getId());
        novoLocatarioDto.setNome(novoLocatario.getNome());
        novoLocatarioDto.setSexo(novoLocatario.getSexo());
        novoLocatarioDto.setTelefone(novoLocatario.getTelefone());
        novoLocatarioDto.setEmail(novoLocatario.getEmail());
        novoLocatarioDto.setDataDeNascimento(novoLocatario.getDataDeNascimento());
        novoLocatarioDto.setCpf(novoLocatario.getCpf());

        return novoLocatarioDto;
    }

    public void deletarPorId(Long id) {
        Optional<Locatario> locatarioOptional = locatarioRepository.findById(id);
        if(locatarioOptional.isPresent())
            locatarioRepository.deleteById(id);
        else
            throw new IllegalArgumentException("Locatario não encontrado");
    }

    public LocatarioDto atualizar(Long id, LocatarioDto locatarioDto) {
        Optional<Locatario> locatarioOptional = locatarioRepository.findById(id);
        if(locatarioOptional.isPresent()) {
            Locatario locatario = locatarioOptional.get();
            locatario.setNome(locatarioDto.getNome());
            locatario.setSexo(locatarioDto.getSexo());
            locatario.setTelefone(locatarioDto.getTelefone());
            locatario.setEmail(locatarioDto.getEmail());
            locatario.setDataDeNascimento(locatarioDto.getDataDeNascimento());
            locatario.setCpf(locatarioDto.getCpf());

            Locatario locatarioAtualizado = locatarioRepository.save(locatario);
            LocatarioDto locatarioAtualizadoDto = new LocatarioDto();
            locatarioAtualizadoDto.setId(locatarioAtualizado.getId());
            locatarioAtualizadoDto.setNome(locatarioAtualizado.getNome());
            locatarioAtualizadoDto.setSexo(locatarioAtualizado.getSexo());
            locatarioAtualizadoDto.setTelefone(locatarioAtualizado.getTelefone());
            locatarioAtualizadoDto.setEmail(locatarioAtualizado.getEmail());
            locatarioAtualizadoDto.setDataDeNascimento(locatarioAtualizado.getDataDeNascimento());
            locatarioAtualizadoDto.setCpf(locatarioAtualizado.getCpf());

            return locatarioAtualizadoDto;
        } else
            throw new IllegalArgumentException("Locatario não encontrado");
    }
}
