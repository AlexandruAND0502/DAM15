package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/")
    public String hello() {
        return "Aplicația funcționează pe portul 8006!";
    }
}

//comanda pentru a rula aplicatia (se pune in terminal): mvn spring-boot:run
