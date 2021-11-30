package com.example.democompositeprimarykey;

import com.example.democompositeprimarykey.entities.DepartmentId;
import com.example.democompositeprimarykey.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class DemoCompositePrimaryKeyApplication implements CommandLineRunner {

    @Autowired
    EmployeeService employeeService;

    public static void main(String[] args) {
        SpringApplication.run(DemoCompositePrimaryKeyApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        employeeService.createDb();

        System.out.println("Department Name: " + employeeService.findDepartmentById(new DepartmentId("M102", "Yangon")));
    }
}
