package com.example.securityfilterchaindemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecretResourcesController {

    @GetMapping("/secret-resources")
    public String index() {
        return "secret-resources";
    }
}
