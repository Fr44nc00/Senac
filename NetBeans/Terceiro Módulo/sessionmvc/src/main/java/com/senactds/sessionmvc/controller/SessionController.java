package com.senactds.sessionmvc.controller; 
import jakarta.servlet.http.HttpServletRequest; 
import jakarta.servlet.http.HttpSession; 
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping; 

@Controller 
@RequestMapping("/sessao") 
public class SessionController { 
    @RequestMapping("/grava") 
    public String gravaSessao(HttpServletRequest request, Model model, String nome){
        HttpSession sessao = request.getSession(); 
        if(sessao != null){ 
            sessao.setAttribute("nome-usuario", nome); 
            model.addAttribute("mensagem", "Gravando Sessao[nome]"); 
        }else{ 
            model.addAttribute("mensagem", "Sessão nula"); 
        } 
        return "sessao"; 
    }
    
    @RequestMapping("/le") 
    public String leSessao(HttpServletRequest request, Model model){ 
        HttpSession sessao = request.getSession(); 
        String nome = ""; 
        if(sessao != null && sessao.getAttribute("nome-usuario") != null){
            nome = (String) sessao.getAttribute("nome-usuario");
        }
        model.addAttribute("mensagem", "Sessao['nome'] = " + nome); 
        return "sessao"; 
    }
}