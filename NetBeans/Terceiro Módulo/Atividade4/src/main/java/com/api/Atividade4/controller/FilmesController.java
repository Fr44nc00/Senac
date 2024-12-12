package com.api.Atividade4.controller;

import com.api.Atividade4.data.FilmeEntity;
import com.api.Atividade4.data.AnaliseEntity;
import com.api.Atividade4.service.FilmeService;
import com.api.Atividade4.service.AnaliseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.api.Atividade4.exception.ResourceNotFoundException;
import jakarta.servlet.http.Cookie; 
import jakarta.servlet.http.HttpServletResponse; 
import org.springframework.web.bind.annotation.CookieValue; 

import java.util.List;

@RestController
@RequestMapping("/filmes-catalogo")
public class FilmesController {

    @Autowired
    private FilmeService filmeService;

    @Autowired
    private AnaliseService analiseService;
    
    @PostMapping("/filmes")
    public ResponseEntity<FilmeEntity> cadastrarFilme(@RequestBody FilmeEntity filme) {
        return ResponseEntity.ok(filmeService.informarFilme(filme));
    }

    @GetMapping("/filmes")
    public ResponseEntity<List<FilmeEntity>> listarFilmes() {
        return ResponseEntity.ok(filmeService.listarTodosFilmes());
    }

    @GetMapping("/filmes/{id}")
    public ResponseEntity<FilmeEntity> buscarFilmePorId(@PathVariable Integer id) {
        return ResponseEntity.ok(filmeService.getFilmeId(id));
    }

    @PutMapping("/filmes/{id}")
    public ResponseEntity<FilmeEntity> atualizarFilme(@PathVariable Integer id,
            @RequestBody FilmeEntity filme) {
        return ResponseEntity.ok(filmeService.atualizarFilme(id, filme));
    }

    @DeleteMapping("/filmes/{id}")
    public ResponseEntity<Void> deletarFilme(@PathVariable Integer id) {
        if (filmeService.deletarFilme(id)) {
            return ResponseEntity.noContent().build();
        }
        throw new ResourceNotFoundException("Filme não encontrado com ID: " + id);
    }

    @PostMapping("/analises")
    public ResponseEntity<AnaliseEntity> cadastrarAnalise(@RequestBody
            AnaliseEntity analise) {
        return ResponseEntity.ok(analiseService.informarAnalise(analise));
    }

    @GetMapping("/analises")
    public ResponseEntity<List<AnaliseEntity>> listarAnalises() {
        return ResponseEntity.ok(analiseService.listarAnalisesPorFilme(null));
    }

    @GetMapping("/filmes/{idFilme}/analises")
    public ResponseEntity<List<AnaliseEntity>> listarAnalisesPorFilme(@PathVariable
            Integer idFilme) {
        if (idFilme == null) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(analiseService.listarAnalisesPorFilme(idFilme));
    }
    
    @GetMapping("/analises/{id}")
    public ResponseEntity<AnaliseEntity> buscarAnalisePorId(@PathVariable Integer id) {
        return ResponseEntity.ok(analiseService.getAnaliseId(id));
    }

    @PutMapping("/analises/{id}")
    public ResponseEntity<AnaliseEntity> atualizarAnalise(@PathVariable Integer id,
            @RequestBody AnaliseEntity analise) {
        return ResponseEntity.ok(analiseService.atualizarAnalise(id, analise));
    }

    @DeleteMapping("/analises/{id}")
    public ResponseEntity<Void> deletarAnalise(@PathVariable Integer id) {
        if (analiseService.deletarAnalise(id)) {
            return ResponseEntity.noContent().build();
        }
        throw new ResourceNotFoundException("Análise não encontrada com ID: " + id);
    }
    
    @GetMapping("/grava-tema")
    public ResponseEntity<String> registraTema(
            @RequestParam String tema,
            HttpServletResponse response) {
        Cookie cookie = new Cookie("theme", tema);
        cookie.setMaxAge(7 * 24 * 60 * 60);
        cookie.setPath("/");
        response.addCookie(cookie);
        return ResponseEntity.ok("Tema gravado: " + tema);
    }

    @GetMapping("/le-tema")
    public ResponseEntity<String> leTema(
            @CookieValue(name = "theme", defaultValue = "light") String tema) {
        return ResponseEntity.ok(tema);
    }
}