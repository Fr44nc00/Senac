package com.senac.exemplothymeleaf.controller;
import org.springframework.stereotype.Controller;
import java.util.List;
import java.util.ArrayList;
import com.senac.exemplothymeleaf.model.Tarefa;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller 
public class TarefaController { 
    private List<Tarefa> tarefas = new ArrayList(); 
    // Abaixo, criaremos nossos métodos novos
    
    @GetMapping("/exibir-tarefa") 
    public String exibirTarefa(Model model) { 
        // Definindo o valor da variável "nome" 
        String nome = "Lucas"; 
        // Criando uma nova instância da classe "Tarefa" com os valores especificados 
        Tarefa tarefa = new Tarefa(1, "Aprender como usar dados dinâmicos com o "
                + "Thymeleaf", true); 
        // Adicionando a variável "nome" ao modelo para ser usada na visualização(view) 
        model.addAttribute("nome", nome); 
        // Adicionando o objeto "tarefa" ao modelo para ser usado na visualização (view) 
        model.addAttribute("tarefa", tarefa); 
        // Retornando o nome da visualização (view) que será renderizada 
        return "exibir-tarefa"; 
    }
    
    @GetMapping("/lista-tarefas")
    public String listaTarefas(Model model) { 
        // Verifica se a lista de tarefas está vazia antes de adicionar novas tarefas
        if (tarefas.isEmpty()) {
            tarefas.add(new Tarefa(1, "Tarefa 1", true)); 
            tarefas.add(new Tarefa(2, "Tarefa 2", true)); 
            tarefas.add(new Tarefa(3, "Tarefa 3", false));
        }
        // Adiciona a coleção tarefas ao modelo
        model.addAttribute("tarefas", tarefas);
        // Retorna o nome da página que será renderizada
        return "lista-tarefas"; 
    }

    
    @GetMapping("/cadastro") 
    public String exibirFormulario(Model model) { 
        // Cria uma nova instância da classe Tarefa e a adiciona ao modelo 
        model.addAttribute("tarefa", new Tarefa()); 
        // Retorna o nome do template "cadastro" para exibir o formulário 
        return "cadastro"; 
    } 
    
    @PostMapping("/cadastro") 
    public String processarFormulario(@ModelAttribute Tarefa tarefa, Model model) { 
        // Define a propriedade "completa" da tarefa como "false" 
        tarefa.setCompleta(false); 
        // Adiciona a tarefa à lista de tarefas (supondo que "tarefas" seja uma lista já existente) 
        tarefas.add(tarefa); 
        // Adiciona a tarefa ao modelo para ser exibida no template "exibir-tarefa" 
        model.addAttribute("tarefa", tarefa); 
        // Retorna o nome do template "exibir-tarefa" para exibir os detalhes da tarefa 
        return "exibir-tarefa"; 
    }
} 
