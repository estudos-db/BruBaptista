package com.example.livraria.controller;

import com.example.livraria.dto.AutorDto;
import com.example.livraria.exception.AutorComLivroException;
import com.example.livraria.exception.AutorDuplicadoException;
import com.example.livraria.exception.AutorNaoEncontradoException;
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
        List<AutorDto> autorDtoLista = autorService.listarTodos();
        if(autorDtoLista.isEmpty())
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.ok(autorDtoLista);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<AutorDto> buscarPorId(@PathVariable long id) {
        AutorDto autorDto = autorService.buscarPorId(id);
        if(autorDto == null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(autorDto);
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<AutorDto>> buscarPorNome(@PathVariable String nome) {
        List<AutorDto> autorDtoLista = autorService.buscarPorNome(nome);
        if(autorDtoLista == null || autorDtoLista.isEmpty())
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(autorDtoLista);
    }

    @PostMapping
    public ResponseEntity<AutorDto> adicionar(@RequestBody AutorDto autorDto) {
        try {
            AutorDto autorDtoAdd = autorService.adicionar(autorDto);
            return ResponseEntity.ok(autorDtoAdd);
        } catch(IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch(AutorDuplicadoException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable long id) {
        try {
            autorService.deletarPorId(id);
            return ResponseEntity.noContent().build();
        } catch(AutorComLivroException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch(AutorNaoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<AutorDto> atualizar(@PathVariable Long id, @RequestBody AutorDto autorDto) {
        try {
            AutorDto autorDtoPut = autorService.atualizar(id, autorDto);
            return ResponseEntity.ok(autorDtoPut);
        } catch(IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}