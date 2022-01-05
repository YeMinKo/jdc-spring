package com.example.preauthorizationdemo.controller;

import com.example.preauthorizationdemo.model.Employee;
import com.example.preauthorizationdemo.service.BookService;
import com.example.preauthorizationdemo.service.NameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    @Autowired
    private NameService nameService;

    @Autowired
    private BookService bookService;

    @GetMapping("/hello")
    public String hello() {
        return "Hello, " + nameService.getName();
    }

    @GetMapping("/secret/names/{name}")
    public List<String> naems(@PathVariable String name) {
        return nameService.getSecretNames(name);
    }

    @GetMapping("/book/details/{name}")
    public Employee getDetails(@PathVariable String name) {
        return bookService.getBookDetail(name);
    }
}
