package com.example.livraria.service;

import com.example.livraria.dto.LocatarioDto;
import com.example.livraria.exception.AutorDuplicadoException;
import com.example.livraria.exception.LocatarioComAluguelException;
import com.example.livraria.exception.LocatarioDuplicadoException;
import com.example.livraria.exception.LocatarioNaoEncontradoException;
import com.example.livraria.model.Aluguel;
import com.example.livraria.model.Locatario;
import com.example.livraria.repository.AluguelRepository;
import com.example.livraria.repository.LocatarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class LocatarioService {

    @Autowired
    private LocatarioRepository locatarioRepository;

    @Autowired
    private AluguelRepository aluguelRepository;

    public void setNome(String nome, Locatario locatario) {
        if(nome == null || nome.isEmpty())
            throw new IllegalArgumentException("Nome inválido");

        locatario.setNome(nome);
    }

    public void setTelefone(String telefone, Locatario locatario) {
        if (!telefone.matches("[0-9]{11}")) {
            throw new IllegalArgumentException("Deve conter somente 11 números");
        }

        StringBuilder sb = new StringBuilder();
        sb.append("(")
                .append(telefone.substring(0, 2))
                .append(")")
                .append(telefone.substring(2));

        locatario.setTelefone(sb.toString());
    }

    public void setEmail(String email, Locatario locatario) {
        if(email == null || !email.contains("@") || email.contains(" "))
            throw new IllegalArgumentException("Email inválido");

        locatario.setEmail(email);
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento, Locatario locatario) {
        if(dataDeNascimento == null || dataDeNascimento.getYear() < 1900)
            throw new IllegalArgumentException("Ano de nascimento inválido");

        locatario.setDataDeNascimento(dataDeNascimento);
    }

    public void setcpf(Integer cpf, Locatario locatario) {
        if(cpf == null || 0 >= cpf)
            throw new IllegalArgumentException("cpf inválido");

        locatario.setCpf(cpf);
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

    private void validarTelefone(LocatarioDto locatarioDto) {
        if(locatarioDto.getTelefone() == null)
            throw new IllegalArgumentException("Telefone não pode ser nulo");

        if(12 > locatarioDto.getTelefone().length())
            throw new IllegalArgumentException("Telefone não pode ter menos que 12 dígitos");

        if(locatarioDto.getTelefone().length() > 13)
            throw new IllegalArgumentException("Telefone não pode ter mais que 13 dígitos");

        if(!locatarioDto.getTelefone().contains("("))
            throw new IllegalArgumentException("Telefone inválido");

        if(!locatarioDto.getTelefone().contains(")"))
            throw new IllegalArgumentException("Telefone inválido");
    }

    public LocatarioDto adicionar(LocatarioDto locatarioDto) {
        List<Locatario> locatarios = locatarioRepository.findAll();
        for(Locatario locatario : locatarios)
            if(locatarioDto.getCpf() == locatario.getCpf())
                throw new LocatarioDuplicadoException("Não é possível criar um locatario duplicado");

        Locatario locatario = new Locatario();
        setNome(locatarioDto.getNome(), locatario);
        setTelefone(locatarioDto.getTelefone(), locatario);
        setEmail(locatarioDto.getEmail(), locatario);
        setDataDeNascimento(locatarioDto.getDataDeNascimento(), locatario);
        setcpf(locatarioDto.getCpf(), locatario);
        locatario.setSexo(locatarioDto.getSexo());


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
        if(!locatarioOptional.isPresent())
            throw new LocatarioNaoEncontradoException("Locatario não encontrado");

        boolean encontrado = false;
        List<Aluguel> aluguelLista = aluguelRepository.findAll();
        for(Aluguel aluguel : aluguelLista)
            if(Objects.equals(aluguel.getLocatario().getId(), id)) {
                encontrado = true;
                break;
            }

        if(encontrado)
            throw new LocatarioComAluguelException("Não é possível excluir um locatario que contém um aluguel");

        locatarioRepository.deleteById(id);
    }

    public LocatarioDto atualizar(Long id, LocatarioDto locatarioDto) {
        Optional<Locatario> locatarioOptional = locatarioRepository.findById(id);
        if(locatarioOptional.isPresent()) {
            Locatario locatario = locatarioOptional.get();
            setNome(locatarioDto.getNome(), locatario);
            setTelefone(locatarioDto.getTelefone(), locatario);
            setEmail(locatarioDto.getEmail(), locatario);
            setDataDeNascimento(locatarioDto.getDataDeNascimento(), locatario);
            setcpf(locatarioDto.getCpf(), locatario);
            locatario.setSexo(locatarioDto.getSexo());

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
