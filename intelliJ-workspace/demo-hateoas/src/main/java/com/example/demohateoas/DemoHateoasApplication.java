package com.example.demohateoas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoHateoasApplication {

    // curl -X GET http://localhost:8080/customers
    public static void main(String[] args) {
        SpringApplication.run(DemoHateoasApplication.class, args);
    }

}
