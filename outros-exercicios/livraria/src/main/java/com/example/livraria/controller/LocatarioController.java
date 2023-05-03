package com.example.livraria.controller;

import com.example.livraria.model.Locatario;
import com.example.livraria.repository.LocatarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locatario")
public class LocatarioController {

    @Autowired
    private LocatarioRepository locatarioRepository;

    @GetMapping
    public List<Locatario> listar() {
        return locatarioRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Locatario adicionar(@RequestBody Locatario locatario) {
        return locatarioRepository.save(locatario);
    }
}
