package com.example.demorequestmapper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyController {

//    @RequestMapping(value = "/", method = RequestMethod.GET) // same as below
    @GetMapping(value = { "/", "/home", "greet"})
    public String helloWorld(Model model) {
        model.addAttribute("msg", "Welcome Java Spring Class");
        return "mypage";
    }

    @GetMapping("/sayspring")
    public String saySpring(Model model) {
        model.addAttribute("msg", "Say Spring");
        return "mypage";
    }

    @GetMapping("/welcome")
    public String saySpringMVC(Model model) {
        model.addAttribute("taglig", "Spring MVC");
        return "welcome";
    }
}
