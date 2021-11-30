package com.example.springdataassignment;

import com.example.springdataassignment.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class SpringDataAssignmentApplication implements CommandLineRunner {

    @Autowired
    private AnimalService animalService;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataAssignmentApplication.class, args);
    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Creating Zoo DB");
        animalService.createDb();
        System.out.println("Completed......");
    }
}
