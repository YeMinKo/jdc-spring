package com.example.customizecsrftoken.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String getHello() {
        return "GET Hello";
    }

    @PostMapping("/hello")
    public String postHello() {
        return "POST Hello";
    }

    @PostMapping("/mary")
    public String postMary() {
        return "Hello Post Mary!";
    }
}
