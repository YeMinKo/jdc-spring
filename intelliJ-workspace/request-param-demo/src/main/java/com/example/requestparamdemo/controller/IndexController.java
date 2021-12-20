package com.example.requestparamdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class IndexController {

    // curl localhost:8080/actionA?name=John
    @GetMapping("/actionA")
    public String actionA(@RequestParam("name") String name ) {
        return String.format("Retrieved name = [%s]", name);
    }

    // curl "localhost:8080/actionB?name=John&city=Mdy"
    // curl "localhost:8080/actionB?name=John"
    @GetMapping("/actionB")
    public String actionB(@RequestParam("name") String name, @RequestParam( value = "city", required = false) Optional city) {
        return String.format("Retrieved name = [%s], city=[%s]", name, city.orElse("Mandalay"));
    }

    // curl "localhost:8080/actionC?name=John&city=Ygn&country=Myanmar"
    @GetMapping("/actionC")
    public String actionC(@RequestParam Map<String, String> parameters) {
        String parametersAsString = parameters.entrySet().stream()
                .map(entry -> String.format("[%s] -> [%s]", entry.getKey(), entry.getValue()))
                .collect(Collectors.joining(", "));
        return String.format("Retrieved parameters map = [%s]", parametersAsString);
    }

    // curl "localhost:8080/actionD?cities=1,2,3"
    @GetMapping("/actionD")
    public String actionD(@RequestParam("cities") List<String> cities) {
        return String.format("Retrieved cities identifiers = [%s]", String.join(", ", cities));
    }

}
