package com.example.livraria.controller;

import com.example.livraria.dto.AutorDto;
import com.example.livraria.dto.LivroDto;
import com.example.livraria.model.Livro;
import com.example.livraria.service.LivroService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livro")
public class LivroController {

    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<LivroDto> listarTodos() {
        return livroService.listarTodos();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public LivroDto buscarPorId(@PathVariable long id) {
        return livroService.buscarPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LivroDto adicionar(@RequestBody LivroDto livroDto) {
        return livroService.adicionar(livroDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarPorId(@PathVariable long id) {
        livroService.deletarPorId(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public LivroDto atualizar(@PathVariable Long id, @RequestBody LivroDto livroDto) {
        return livroService.atualizar(id, livroDto);
    }
}