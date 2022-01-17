package com.example.csrfdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private static Logger logger = LoggerFactory.getLogger(TestController.class);

    @Value("${test.hello}")
    private String test;

    @PostMapping("/a")
    public String postEndPointA(){
        return "Works";
    }

    @GetMapping("/a")
    public String getEndPointA(){
        logger.info("TEST: " + test);
        return "Works";
    }

    @GetMapping("/a/b")
    public String getEndPointB(){
        return "Works";
    }

    @GetMapping("/a/b/c")
    public String getEndPointC(){
        return "Works";
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }
}
