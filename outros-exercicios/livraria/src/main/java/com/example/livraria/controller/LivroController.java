package com.example.livraria.controller;

import com.example.livraria.dto.LivroDto;
import com.example.livraria.exception.LivroAlugadoException;
import com.example.livraria.exception.LivroNaoEncontradoException;
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
        List<LivroDto> livroDtoLista = livroService.listarTodos();
        if(livroDtoLista.isEmpty())
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.ok(livroDtoLista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroDto> buscarPorId(@PathVariable long id) {
        LivroDto livroDto = livroService.buscarPorId(id);
        if(livroDto == null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(livroDto);
    }

    @GetMapping("/autor/{nome}")
    public ResponseEntity<List<LivroDto>> buscarPorAutor(@PathVariable String nome) {
        List<LivroDto> livroDtoLista = livroService.buscarPorAutor(nome);
        if(livroDtoLista.isEmpty())
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.ok(livroDtoLista);
    }

    @GetMapping("/locatario/{nome}")
    public ResponseEntity<List<LivroDto>> buscarPorLocatario(@PathVariable String nome) {
        List<LivroDto> livroDtoLista = livroService.buscarPorLocatario(nome);
        if(livroDtoLista.isEmpty())
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.ok(livroDtoLista);
    }

    @GetMapping("/disponiveis")
    public ResponseEntity<List<LivroDto>> buscarDisponiveis() {
        List<LivroDto> livroDtoLista = livroService.buscarDisponiveis();
        if(livroDtoLista.isEmpty())
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.ok(livroDtoLista);
    }

    @GetMapping("/indisponiveis")
    public ResponseEntity<List<LivroDto>> buscarIndisponiveis() {
        List<LivroDto> livroDtoLista = livroService.buscarIndisponiveis();
        if(livroDtoLista.isEmpty())
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.ok(livroDtoLista);
    }

    @PostMapping
    public ResponseEntity<LivroDto> adicionar(@RequestBody LivroDto livroDto) {
        try {
            LivroDto livroDtoAdd = livroService.adicionar(livroDto);
            return ResponseEntity.ok(livroDtoAdd);
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
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        } catch (LivroAlugadoException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (LivroNaoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<LivroDto> atualizar(@PathVariable Long id, @RequestBody LivroDto livroDto) {
        try {
            LivroDto livroDtoPut = livroService.atualizar(id, livroDto);
            return ResponseEntity.ok(livroDtoPut);
        } catch(IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}