package com.example.livraria.controller;

import com.example.livraria.dto.AluguelDto;
import com.example.livraria.dto.AutorDto;
import com.example.livraria.model.Aluguel;
import com.example.livraria.repository.AluguelRepository;
import com.example.livraria.service.AluguelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aluguel")
public class AluguelController {

    private final AluguelService aluguelService;

    public AluguelController(AluguelService aluguelService) {
        this.aluguelService = aluguelService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AluguelDto> listarTodos() {
        return aluguelService.listarTodos();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AluguelDto buscarPorId(@PathVariable long id) {
        return aluguelService.buscarPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AluguelDto adicionar() {
        return aluguelService.adicionar();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarPorId(@PathVariable long id) {
        aluguelService.deletarPorId(id);
    }
}
