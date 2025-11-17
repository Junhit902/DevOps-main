package com.projeto.meuprojeto.application.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "API de Alunos está rodando. Use /alunos para acessar os endpoints.";
    }
}
