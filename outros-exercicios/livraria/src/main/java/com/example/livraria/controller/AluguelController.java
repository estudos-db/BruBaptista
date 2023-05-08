package com.example.livraria.controller;

import com.example.livraria.dto.AluguelDto;
import com.example.livraria.service.AluguelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<AluguelDto>> listarTodos() {
        if(aluguelService.listarTodos().isEmpty())
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.ok(aluguelService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AluguelDto> buscarPorId(@PathVariable long id) {
        if(aluguelService.buscarPorId(id) == null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(aluguelService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<AluguelDto> adicionar() {
        try {
            return ResponseEntity.ok(aluguelService.adicionar());
        } catch(IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable long id) {
        try {
            aluguelService.deletarPorId(id);
            return ResponseEntity.noContent().build();
        } catch(IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<AluguelDto> atualizar(@PathVariable Long id, @RequestBody AluguelDto aluguelDto) {
        try {
            return ResponseEntity.ok(aluguelService.atualizar(id, aluguelDto));
        } catch(IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
