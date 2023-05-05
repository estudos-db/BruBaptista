package com.example.livraria.controller;

import com.example.livraria.dto.AutorDto;
import com.example.livraria.service.AutorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autor")
public class AutorController {

    private final AutorService autorService;

    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AutorDto> listarTodos() {
        return autorService.listarTodos();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AutorDto buscarPorId(@PathVariable long id) {
        return autorService.buscarPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AutorDto adicionar(@RequestBody AutorDto autorDto) {
        return autorService.adicionar(autorDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarPorId(@PathVariable long id) {
        autorService.deletarPorId(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AutorDto atualizar(@PathVariable Long id, @RequestBody AutorDto autorDto) {
        return autorService.atualizar(id, autorDto);
    }
}