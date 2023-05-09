package com.example.livraria.service;

import com.example.livraria.dto.AluguelDto;
import com.example.livraria.model.Aluguel;
import com.example.livraria.model.Livro;
import com.example.livraria.model.Locatario;
import com.example.livraria.repository.AluguelRepository;
import com.example.livraria.repository.LivroRepository;
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

    @Autowired
    private LivroRepository livroRepository;

    public void setLocatario(Locatario locatario, Aluguel aluguel) {
        if(locatario == null)
            throw new IllegalArgumentException("Locatário inválido");

        aluguel.setLocatario(locatario);
    }

    public void setLivros(List<Livro> livros, Aluguel aluguel) {
        if(livros == null || livros.isEmpty())
            throw new IllegalArgumentException("Lista de livros inválida");
        else
            aluguel.setLivros(livros);
    }

    public void setDataRetirada(LocalDate dataRetirada, Aluguel aluguel) {
        if(dataRetirada == null)
            throw new IllegalArgumentException("Data de retirada inválida");

        aluguel.setDataRetirada(dataRetirada);
    }

    public void setDataDevolucao(LocalDate dataDevolucao, Aluguel aluguel) {
        if(dataDevolucao == null)
            throw new IllegalArgumentException("Data de devolução inválida");

        aluguel.setDataDevolucao(dataDevolucao);
    }

    public List<AluguelDto> listarTodos() {
        List<Aluguel> aluguelLista = aluguelRepository.findAll();
        List<AluguelDto> aluguelDtoLista = new ArrayList<>();
        for(Aluguel aluguel : aluguelLista) {
            AluguelDto aluguelDto = new AluguelDto();
            aluguelDto.setId(aluguel.getId());
            aluguelDto.setLocatario(aluguel.getLocatario());
            aluguelDto.setLivros(aluguel.getLivros());
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
            aluguelDto.setLocatario(aluguel.getLocatario());
            aluguelDto.setLivros(aluguel.getLivros());
            aluguelDto.setDataRetirada(aluguel.getDataRetirada());
            aluguelDto.setDataDevolucao(aluguel.getDataDevolucao());
            return aluguelDto;
        } else
            throw new IllegalArgumentException("Aluguel não encontrado");
    }

    public AluguelDto adicionar(AluguelDto aluguelDto) {
        Aluguel aluguel = new Aluguel();
        setLocatario(aluguelDto.getLocatario(), aluguel);
        setLivros(aluguelDto.getLivros(), aluguel);
        aluguel.setDataRetirada(LocalDate.now());
        aluguel.setDataDevolucao(LocalDate.now().plusDays(2));

        Aluguel novoAluguel = aluguelRepository.save(aluguel);
        AluguelDto novoAluguelDto = new AluguelDto();
        novoAluguelDto.setId(novoAluguel.getId());
        novoAluguelDto.setLocatario(novoAluguel.getLocatario());
        novoAluguelDto.setLivros(novoAluguel.getLivros());
        novoAluguelDto.setDataRetirada(novoAluguel.getDataRetirada());
        novoAluguelDto.setDataDevolucao(novoAluguel.getDataDevolucao());

        List<Livro> livrosAtualizados = new ArrayList<>();
        List<Livro> livroLista = aluguelDto.getLivros();
        for(int i = 0; i < livroLista.size(); i++) {
            Livro livro = livroRepository.getReferenceById(livroLista.get(i).getId());
            livro.setAlugado(true);
            livrosAtualizados.add(livro);
        }
        livroRepository.saveAll(livrosAtualizados);

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
            setLocatario(aluguelDto.getLocatario(), aluguel);
            setLivros(aluguelDto.getLivros(), aluguel);
            aluguel.setDataRetirada(aluguelDto.getDataRetirada());
            aluguel.setDataDevolucao(aluguelDto.getDataDevolucao());

            Aluguel aluguelAtualizado = aluguelRepository.save(aluguel);
            AluguelDto aluguelAtualizadoDto = new AluguelDto();
            aluguelAtualizadoDto.setLocatario(aluguelAtualizado.getLocatario());
            aluguelAtualizadoDto.setLivros(aluguelAtualizado.getLivros());
            aluguelAtualizadoDto.setDataRetirada(aluguelAtualizado.getDataRetirada());
            aluguelAtualizadoDto.setDataDevolucao(aluguelAtualizado.getDataDevolucao());

            return aluguelAtualizadoDto;
        } else
            throw new IllegalArgumentException("Aluguel não encontrado");
    }
}