package com.example.livraria.controller;

import com.example.livraria.model.Aluguel;
import com.example.livraria.repository.AluguelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aluguel")
public class AluguelController {

    @Autowired
    private AluguelRepository aluguelRepository;

    @GetMapping
    public List<Aluguel> listar() {
        return aluguelRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Aluguel adicionar(@RequestBody Aluguel aluguel) {
        return aluguelRepository.save(aluguel);
    }
}
