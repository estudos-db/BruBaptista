package com.example.livraria.controller;

import com.example.livraria.dto.LivroDto;
import com.example.livraria.service.LivroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<LivroDto>> listarTodos() {
        if(livroService.listarTodos().isEmpty())
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.ok(livroService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroDto> buscarPorId(@PathVariable long id) {
        if(livroService.buscarPorId(id) == null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(livroService.buscarPorId(id));
    }

//    @GetMapping("/autor/{nome}")
//    public List<LivroDto> buscarPorNome(@PathVariable String nome) {
//        return livroService.buscarPorAutor(nome);
//    }

    @PostMapping
    public ResponseEntity<LivroDto> adicionar(@RequestBody LivroDto livroDto) {
        try {
            return ResponseEntity.ok(livroService.adicionar(livroDto));
        } catch(IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable long id) {
        try {
            livroService.deletarPorId(id);
            return ResponseEntity.noContent().build();
        } catch(IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<LivroDto> atualizar(@PathVariable Long id, @RequestBody LivroDto livroDto) {
        try {
            return ResponseEntity.ok(livroService.atualizar(id, livroDto));
        } catch(IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}