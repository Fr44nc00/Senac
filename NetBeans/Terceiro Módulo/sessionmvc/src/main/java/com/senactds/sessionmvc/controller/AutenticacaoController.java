package com.senactds.sessionmvc.controller; 

import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.RequestMapping;
import com.senactds.sessionmvc.model.Usuario;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller 
public class AutenticacaoController { 
    @RequestMapping("/") 
    public String index(){ 
        return "login"; 
    }
    
    @PostMapping("/autentica") 
    public String autentica(HttpServletRequest request, Usuario usuario){
        //Preenche "adm" e "123" pra funcionar
        HttpSession sessao = request.getSession(); 
        if(sessao != null && usuario.getLogin().equals("adm")
                && usuario.getSenha().equals("123")){ 
            sessao.setAttribute("usuario", usuario.getLogin()); 
            return "protegida"; 
        } 
        return "login";
    }
    
    @RequestMapping("/protegida") 
    public ModelAndView acessaProtegida(HttpServletRequest request){ 
        HttpSession sessao = request.getSession(); 
        if(sessao != null && sessao.getAttribute("usuario") != null && sessao.getAttribute("usuario").equals("adm")){ 
            return new ModelAndView("protegida"); 
        } 
        return new ModelAndView("redirect:/"); 
    }
    
    @RequestMapping("/logoff") 
    public ModelAndView fazLogoff(HttpServletRequest request){ 
        HttpSession sessao = request.getSession(); 
        if(sessao != null ) 
            sessao.removeAttribute("usuario"); 
        return new ModelAndView("redirect:/"); 
    }
}   