package com.api.Catalogo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import java.util.List;
import java.util.ArrayList;
import com.api.Catalogo.model.Filme;
import com.api.Catalogo.model.Analise;
import java.util.stream.Collectors;

@Controller
public class CatalogoController {
    private List<Filme> filmes = new ArrayList<>();
    private List<Analise> analises = new ArrayList<>();
    
    @GetMapping("/listar-filmes")
    public String listaFilme(Model model) {
        if (filmes.isEmpty()) {
            filmes.add(new Filme(1, "Vingadores", 
                "Com seu grande exército alienígena, o deus nórdico Loki planeja invadir "
                + "a Terra. Cabe a um time inesperado de heróis se unirem para "
                + "impedir que o deus da mentira domine o planeta",
                "Ação", 2012));
            filmes.add(new Filme(2, "Meu Malvado Favorito", 
                "Sendo chamado de ultrapassado por seus pares, o vilão Gru bola um plano"
                + " para fazer o maior roubo de todos os tempos. O que ele não contava"
                + " era com 3 garotinhas virando sua vida de cabeça pra baixo.",
                "Comédia", 2010));
            filmes.add(new Filme(3, "Transformers ONE", 
                "Veja como Orion Pax e D-16 se tornaram Optimus Prime e Megatron, e sua jornada"
                + " de amigos para inimigos mortais nessa aventura épica em 3D que "
                + "conta a história da origem da guerra entre Autobots e Decepticons.",
                "Ação", 2024));
        }
        model.addAttribute("filmes", filmes);
        return "listar-filmes";
    }

    @GetMapping("/filmes/{id}")
    public String detalhesFilme(@PathVariable int id, Model model) {
        Filme filme = filmes.stream()
                            .filter(f -> f.getId() == id)  // Comparando ids com int
                            .findFirst()
                            .orElseThrow(() -> new IllegalArgumentException(
                                    "Filme não encontrado: " + id));

        model.addAttribute("filme", filme);
        return "detalhes-filme";
    }

    @GetMapping("/cadastrar-filme")
    public String cadastrandoFilme(Model model) {  
        model.addAttribute("filme", new Filme()); 
        return "cadastrar-filme"; 
    } 
    
    @PostMapping("/cadastrar-filme")
    public String processarFormulario1(@ModelAttribute Filme filme, Model model) {
        int idFilme = filmes.size() + 1;
        filme.setId(idFilme);
        filmes.add(filme);
        return "redirect:/listar-filmes";
    }

    @GetMapping("/filmes/{id}/atualizar")
    public String atualizarFilme(@PathVariable int id, Model model) {
        Filme filme = filmes.stream()
                            .filter(f -> f.getId() == id)
                            .findFirst()
                            .orElseThrow(() -> new IllegalArgumentException("Filme não encontrado: " + id));
        model.addAttribute("filme", filme);
        return "atualizar-filme";
    }

    @PostMapping("/filmes/{id}/atualizar")
    public String atualizarFilmeProcesso(@PathVariable int id, @ModelAttribute Filme filmeAtualizado) {
        Filme filme = filmes.stream()
                            .filter(f -> f.getId() == id)
                            .findFirst()
                            .orElseThrow(() -> new IllegalArgumentException("Filme não encontrado: " + id));
        filme.setTitulo(filmeAtualizado.getTitulo());
        filme.setSinopse(filmeAtualizado.getSinopse());
        filme.setGenero(filmeAtualizado.getGenero());
        filme.setAnoLancamento(filmeAtualizado.getAnoLancamento());

        return "redirect:/filmes/{id}";
    }

    @GetMapping("/filmes/{id}/deletar")
    public String deletarFilme(@PathVariable int id) {
        Filme filme = filmes.stream()
                            .filter(f -> f.getId() == id)
                            .findFirst()
                            .orElseThrow(() -> new IllegalArgumentException("Filme não encontrado: " + id));
        filmes.remove(filme);
        return "redirect:/listar-filmes";
    }

    @GetMapping("/filmes/{id}/analises")
    public String listarAnalises(@PathVariable int id, Model model) {
        List<Analise> analisesDoFilme = analises.stream()
            .filter(a -> a.getIdFilme() == id)
            .collect(Collectors.toList());

        Filme filme = filmes.stream()
                            .filter(f -> f.getId() == id)
                            .findFirst()
                            .orElseThrow(() -> new IllegalArgumentException(
                                    "Filme não encontrado: " + id));

        model.addAttribute("filme", filme);
        model.addAttribute("analises", analisesDoFilme);

        return "detalhes-filme";
    }

    @GetMapping("/filmes/{id}/informar-analise")
    public String cadastrandoAnalise(@PathVariable int id, Model model) {
        Analise analise = new Analise();
        analise.setIdFilme(id);
        model.addAttribute("analise", analise);
        return "informar-analise";
    }

    @PostMapping("/filmes/{id}/informar-analise")
    public String processarFormulario2(@PathVariable int id, @ModelAttribute Analise analise, Model model) {
        int idAnalise = analises.size() + 1;
        analise.setId(idAnalise);
        analise.setIdFilme(id);
        analises.add(analise);
        return "redirect:/filmes/" + id + "/analises";
    }

    @GetMapping("/filmes/{id}/analises/{analiseId}/atualizar")
    public String atualizarAnalise(@PathVariable int id, @PathVariable int analiseId, Model model) {
        Analise analise = analises.stream()
            .filter(a -> a.getId() == analiseId)
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("Análise não encontrada: " + analiseId));

        model.addAttribute("analise", analise);
        model.addAttribute("filme", filmes.stream().filter(f -> f.getId() == id).findFirst().get());
        return "atualizar-analise";
    }

    @PostMapping("/filmes/{id}/analises/{analiseId}/atualizar")
    public String atualizarAnaliseProcesso(@PathVariable int id, @PathVariable int analiseId, @ModelAttribute Analise analiseAtualizada) {
        Analise analise = analises.stream()
            .filter(a -> a.getId() == analiseId)
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("Análise não encontrada: " + analiseId));

        analise.setNota(analiseAtualizada.getNota());
        analise.setDetalhes(analiseAtualizada.getDetalhes());

        return "redirect:/filmes/{id}/analises";
    }

    @GetMapping("/filmes/{id}/analises/{analiseId}/deletar")
    public String deletarAnalise(@PathVariable int id, @PathVariable int analiseId) {
        Analise analise = analises.stream()
            .filter(a -> a.getId() == analiseId)
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("Análise não encontrada: " + analiseId));

        analises.remove(analise);
        return "redirect:/filmes/{id}/analises";
    }
}