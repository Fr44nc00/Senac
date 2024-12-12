package com.api.Atividade2.controller;

import com.api.Atividade2.data.FilmeEntity;
import com.api.Atividade2.data.AnaliseEntity;
import com.api.Atividade2.service.FilmeService;
import com.api.Atividade2.service.AnaliseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filmes-catalogo")
public class FilmesController2 {

    @Autowired
    FilmeService filmeService;

    @Autowired
    AnaliseService analiseService;

    @PostMapping("/adicionando")
    public ResponseEntity<FilmeEntity> addFilme(@Valid @RequestBody FilmeEntity filme) {
        FilmeEntity novoFilme = filmeService.informarFilme(filme);
        return new ResponseEntity<>(novoFilme, HttpStatus.CREATED);
    }

    @GetMapping("/listando")
    public ResponseEntity<List<FilmeEntity>> getAllFilmes() {
        List<FilmeEntity> filmes = filmeService.listarTodosFilmes();
        return new ResponseEntity<>(filmes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FilmeEntity> getFilmeById(@PathVariable Integer id) {
        FilmeEntity filme = filmeService.getFilmeId(id);
        return new ResponseEntity<>(filme, HttpStatus.OK);
    }

    @GetMapping("/pesquisando/{titulo}")
    public ResponseEntity<List<FilmeEntity>> getFilmesByTitulo(@PathVariable String titulo) {
        List<FilmeEntity> filmes = filmeService.getFilmePorTitulo(titulo);
        return new ResponseEntity<>(filmes, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FilmeEntity> atualizarFilme(
            @PathVariable Integer id,
            @Valid @RequestBody FilmeEntity filmeAtualizado) {
        FilmeEntity filme = filmeService.atualizarFilme(id, filmeAtualizado);
        return new ResponseEntity<>(filme, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFilme(@PathVariable Integer id) {
        filmeService.deletarFilme(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/{id}/adicionando-analise")
    public ResponseEntity<AnaliseEntity> adicionarAnalise(
            @PathVariable Integer id,
            @Valid @RequestBody AnaliseEntity novaAnalise) {
        FilmeEntity filme = filmeService.getFilmeId(id);
        novaAnalise.setFilme(filme);
        AnaliseEntity analiseSalva = analiseService.informarAnalise(novaAnalise);
        return new ResponseEntity<>(analiseSalva, HttpStatus.CREATED);
    }

    @GetMapping("/{id}/analises-filme")
    public ResponseEntity<List<AnaliseEntity>> listarAnalisesPorFilme(@PathVariable Integer id) {
        List<AnaliseEntity> analises = analiseService.listarAnalisesPorFilme(id);
        return new ResponseEntity<>(analises, HttpStatus.OK);
    }

    @PutMapping("/analises/{analiseId}")
    public ResponseEntity<AnaliseEntity> atualizarAnalise(
            @PathVariable Integer analiseId,
            @Valid @RequestBody AnaliseEntity analiseAtualizada) {
        AnaliseEntity analise = analiseService.atualizarAnalise(analiseId, analiseAtualizada);
        return new ResponseEntity<>(analise, HttpStatus.OK);
    }

    @DeleteMapping("/analises/{analiseId}")
    public ResponseEntity<Void> deletarAnalise(@PathVariable Integer analiseId) {
        analiseService.deletarAnalise(analiseId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}