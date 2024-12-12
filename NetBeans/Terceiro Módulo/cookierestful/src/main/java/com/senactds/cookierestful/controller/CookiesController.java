package com.senactds.cookierestful.controller;

import jakarta.servlet.http.Cookie; 
import jakarta.servlet.http.HttpServletResponse; 
import org.springframework.web.bind.annotation.CookieValue; 
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController; 

@RestController 
@RequestMapping("/cookies") 
public class CookiesController { 
    @GetMapping("/grava") 
    public String registraCookie(HttpServletResponse response) { 
        Cookie c = new Cookie("user-id", "123abc"); 
        response.addCookie(c); 
        return "Gravando cookie"; 
    } 
    @GetMapping("/le") 
    public String leCookie(@CookieValue(name="user-id",
            defaultValue="nenhum-valor") String userId) { 
        return "cookie: " + userId; 
    } 
}