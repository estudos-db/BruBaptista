package com.example.livraria.controller;

import com.example.livraria.dto.AutorDto;
import com.example.livraria.dto.LocatarioDto;
import com.example.livraria.model.Locatario;
import com.example.livraria.repository.LocatarioRepository;
import com.example.livraria.service.LocatarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    @ResponseStatus(HttpStatus.OK)
    public List<LocatarioDto> listarTodos() {
        return locatarioService.listarTodos();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public LocatarioDto buscarPorId(@PathVariable long id) {
        return locatarioService.buscarPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LocatarioDto adicionar(@RequestBody LocatarioDto locatarioDto) {
        return locatarioService.adicionar(locatarioDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarPorId(@PathVariable long id) {
        locatarioService.deletarPorId(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public LocatarioDto atualizar(@PathVariable Long id, @RequestBody LocatarioDto locatarioDto) {
        return locatarioService.atualizar(id, locatarioDto);
    }
}