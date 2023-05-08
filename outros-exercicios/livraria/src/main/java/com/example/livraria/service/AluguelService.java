package com.example.livraria.service;

import com.example.livraria.dto.AluguelDto;
import com.example.livraria.model.Aluguel;
import com.example.livraria.repository.AluguelRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AluguelService {

    @Autowired
    private AluguelRepository aluguelRepository;

    public void setDataRetirada(LocalDate dataRetirada, AluguelDto aluguelDto) {
        if(dataRetirada == null)
            throw new IllegalArgumentException("Data de retirada inválida");

        aluguelDto.setDataRetirada(dataRetirada);
    }

    public void setDataDevolucao(LocalDate dataDevolucao, AluguelDto aluguelDto) {
        if(dataDevolucao == null)
            throw new IllegalArgumentException("Data de devolução inválida");

        aluguelDto.setDataDevolucao(dataDevolucao);
    }

    public AluguelDto criar(AluguelDto aluguelDto) {
        setDataRetirada(aluguelDto.getDataRetirada(), aluguelDto);
        setDataDevolucao(aluguelDto.getDataDevolucao(), aluguelDto);

        Aluguel aluguel = new Aluguel();
        BeanUtils.copyProperties(aluguelDto, aluguel);
        aluguel = aluguelRepository.save(aluguel);
        BeanUtils.copyProperties(aluguel, aluguelDto);

        return aluguelDto;
    }

    public List<AluguelDto> listarTodos() {
        List<Aluguel> aluguelLista = aluguelRepository.findAll();
        List<AluguelDto> aluguelDtoLista = new ArrayList<>();
        for(Aluguel aluguel : aluguelLista) {
            AluguelDto aluguelDto = new AluguelDto();
            aluguelDto.setId(aluguel.getId());
            aluguelDto.setDataRetirada(aluguel.getDataRetirada());
            aluguelDto.setDataDevolucao(aluguel.getDataDevolucao());
            aluguelDtoLista.add(aluguelDto);
        }
        return aluguelDtoLista;
    }

    public AluguelDto buscarPorId(Long id) {
        Optional<Aluguel> aluguelOptional = aluguelRepository.findById(id);
        if(aluguelOptional.isPresent()) {
            Aluguel aluguel = aluguelOptional.get();
            AluguelDto aluguelDto = new AluguelDto();
            aluguelDto.setId(aluguel.getId());
            aluguelDto.setDataRetirada(aluguel.getDataRetirada());
            aluguelDto.setDataDevolucao(aluguel.getDataDevolucao());
            return aluguelDto;
        } else
            throw new IllegalArgumentException("Aluguel não encontrado");
    }

    public AluguelDto adicionar() {
        Aluguel aluguel = new Aluguel();

        Aluguel novoAluguel = aluguelRepository.save(aluguel);
        AluguelDto novoAluguelDto = new AluguelDto();
        novoAluguelDto.setId(novoAluguel.getId());
        novoAluguelDto.setDataRetirada(novoAluguel.getDataRetirada());
        novoAluguelDto.setDataDevolucao(novoAluguel.getDataDevolucao());

        return novoAluguelDto;
    }

    public void deletarPorId(Long id) {
        Optional<Aluguel> aluguelOptional = aluguelRepository.findById(id);
        if(aluguelOptional.isPresent())
            aluguelRepository.deleteById(id);
        else
            throw new IllegalArgumentException("Aluguel não encontrado");
    }

    public AluguelDto atualizar(Long id, AluguelDto aluguelDto) {
        Optional<Aluguel> aluguelOptional = aluguelRepository.findById(id);
        if(aluguelOptional.isPresent()) {
            Aluguel aluguel = aluguelOptional.get();
            aluguel.setDataRetirada(aluguelDto.getDataRetirada());
            aluguel.setDataDevolucao(aluguelDto.getDataDevolucao());

            Aluguel aluguelAtualizado = aluguelRepository.save(aluguel);
            AluguelDto aluguelAtualizadoDto = new AluguelDto();
            aluguelAtualizadoDto.setDataRetirada(aluguelAtualizado.getDataRetirada());
            aluguelAtualizadoDto.setDataDevolucao(aluguelAtualizado.getDataDevolucao());

            return aluguelAtualizadoDto;
        } else
            throw new IllegalArgumentException("Aluguel não encontrado");
    }
}
