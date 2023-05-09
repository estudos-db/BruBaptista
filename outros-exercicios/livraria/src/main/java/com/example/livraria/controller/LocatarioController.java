package com.example.livraria.controller;

import com.example.livraria.dto.LocatarioDto;
import com.example.livraria.exception.LocatarioComAluguelException;
import com.example.livraria.exception.LocatarioDuplicadoException;
import com.example.livraria.exception.LocatarioNaoEncontradoException;
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
        List<LocatarioDto> LocatarioDtoLista = locatarioService.listarTodos();
        if(LocatarioDtoLista.isEmpty())
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.ok(LocatarioDtoLista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LocatarioDto> buscarPorId(@PathVariable long id) {
        LocatarioDto locatarioDto = locatarioService.buscarPorId(id);
        if(locatarioDto == null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(locatarioDto);
    }

    @PostMapping
    public ResponseEntity<LocatarioDto> adicionar(@RequestBody LocatarioDto locatarioDto) {
        try {
            LocatarioDto locatarioDtoAdd = locatarioService.adicionar(locatarioDto);
            return ResponseEntity.ok(locatarioDtoAdd);
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch(LocatarioDuplicadoException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable long id) {
        try {
            locatarioService.deletarPorId(id);
            return ResponseEntity.noContent().build();
        } catch(IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        } catch (LocatarioComAluguelException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (LocatarioNaoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<LocatarioDto> atualizar(@PathVariable Long id, @RequestBody LocatarioDto locatarioDto) {
        try {
            LocatarioDto locatarioDtoPut = locatarioService.atualizar(id, locatarioDto);
            return ResponseEntity.ok(locatarioDtoPut);
        } catch(IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}