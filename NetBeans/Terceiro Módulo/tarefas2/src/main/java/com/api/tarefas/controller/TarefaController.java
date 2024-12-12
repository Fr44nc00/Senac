package com.api.tarefas.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.api.tarefas.model.Tarefa;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {
    private List<Tarefa> tarefas = new ArrayList<>();
    private int proximoId = 1;

    @GetMapping
    public List<Tarefa> buscarTodasTarefas() {
        return tarefas;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> buscarTarefaPorId(@PathVariable int id) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getId() == id) {
                return ResponseEntity.ok(tarefa);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public Tarefa criarTarefa(@RequestBody Tarefa tarefa) {
        tarefa.setId(proximoId++);
        tarefas.add(tarefa);
        return tarefa;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> atualizarTarefa(@PathVariable int id, @RequestBody Tarefa tarefaAtualizada) {
        for (int i = 0; i < tarefas.size(); i++) {
            Tarefa tarefa = tarefas.get(i);
            if (tarefa.getId() == id) {
                tarefa.setDescricao(tarefaAtualizada.getDescricao());
                tarefa.setCompleta(tarefaAtualizada.isCompleta());
                return ResponseEntity.ok(tarefa);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTarefa(@PathVariable int id) {
        for (int i = 0; i < tarefas.size(); i++) {
            Tarefa tarefa = tarefas.get(i);
            if (tarefa.getId() == id) {
                tarefas.remove(i);
                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.notFound().build();
    }
}