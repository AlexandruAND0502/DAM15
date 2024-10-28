package com.example.uniproject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api") 
public class UniprojectController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello world";
    }
}
