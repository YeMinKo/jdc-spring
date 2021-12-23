package com.example.crossorigindemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    private Logger logger = LoggerFactory.getLogger(HelloController.class.getName());

    @GetMapping("/")
    public String main(){
        return "main";
    }

//    @CrossOrigin("http://localhost:8080")
    @PostMapping("/test")
    @ResponseBody
    public String test() {
        logger.info("Test method is called.");
        return "Hello";
    }
}
