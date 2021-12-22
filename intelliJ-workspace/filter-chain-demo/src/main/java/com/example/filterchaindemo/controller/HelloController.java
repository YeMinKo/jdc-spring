package com.example.filterchaindemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    /** curl -H "Request-Id:123"  http://localhost:8080/hello */
    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }
}
