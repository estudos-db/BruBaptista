package com.example.livraria.controller;

import com.example.livraria.dto.LocatarioDto;
import com.example.livraria.service.LocatarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locatario")
public class LocatarioController {

    private final LocatarioService locatarioService;

    public LocatarioController(LocatarioService locatarioService) {
        this.locatarioService = locatarioService;
    }

    @GetMapping
    public ResponseEntity<List<LocatarioDto>> listarTodos() {
        if(locatarioService.listarTodos().isEmpty())
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.ok(locatarioService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LocatarioDto> buscarPorId(@PathVariable long id) {
        if(locatarioService.buscarPorId(id) == null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(locatarioService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<LocatarioDto> adicionar(@RequestBody LocatarioDto locatarioDto) {
        try {
            return ResponseEntity.ok(locatarioService.adicionar(locatarioDto));
        } catch(IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable long id) {
        try {
            locatarioService.deletarPorId(id);
            return ResponseEntity.noContent().build();
        } catch(IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<LocatarioDto> atualizar(@PathVariable Long id, @RequestBody LocatarioDto locatarioDto) {
        try {
            return ResponseEntity.ok(locatarioService.atualizar(id, locatarioDto));
        } catch(IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}