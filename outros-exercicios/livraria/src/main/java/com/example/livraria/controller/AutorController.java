package com.example.livraria.controller;

import com.example.livraria.dto.AutorDto;
import com.example.livraria.service.AutorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<AutorDto>> listarTodos() {
        if(autorService.listarTodos().isEmpty())
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.ok(autorService.listarTodos());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<AutorDto> buscarPorId(@PathVariable long id) {
        if(autorService.buscarPorId(id) == null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(autorService.buscarPorId(id));
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<AutorDto>> buscarPorNome(@PathVariable String nome) {
        if(autorService.buscarPorNome(nome) == null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(autorService.buscarPorNome(nome));
    }

    @PostMapping
    public ResponseEntity<AutorDto> adicionar(@RequestBody AutorDto autorDto) {
        try {
            return ResponseEntity.ok(autorService.adicionar(autorDto));
        } catch(IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable long id) {
        try {
            autorService.deletarPorId(id);
            return ResponseEntity.noContent().build();
        } catch(IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<AutorDto> atualizar(@PathVariable Long id, @RequestBody AutorDto autorDto) {
        try {
            return ResponseEntity.ok(autorService.atualizar(id, autorDto));
        } catch(IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}