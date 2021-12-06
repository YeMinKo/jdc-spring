package com.example.jpaquerydemo;

import com.example.jpaquerydemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaQueryDemoApplication implements CommandLineRunner {

    @Autowired
    private EmployeeService employeeService;

    public static void main(String[] args) {
        SpringApplication.run(JpaQueryDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        employeeService.queryEmployee();
    }
}
