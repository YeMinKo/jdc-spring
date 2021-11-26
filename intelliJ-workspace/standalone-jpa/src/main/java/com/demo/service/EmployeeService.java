package com.demo.service;

import com.demo.dao.EmployeeDao;
import com.demo.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    public void saveAllEmployees() {
        System.out.println("Saving All Employees.");

        employeeDao.save(new Employee(1, "John", "Willian", "john@gmail.com", "55-55-55", Date.valueOf("2020-8-05"), 50000));
        employeeDao.save(new Employee(2, "John", "Doe", "doe@gmail.com", "55-55-55", Date.valueOf("2020-8-07"), 150000));
        employeeDao.save(new Employee(3, "John", "Update", "update@gmail.com", "55-55-55", Date.valueOf("2020-8-11"), 80000));

        System.out.println("Saved all employees.");
    }

    public void listAllEmployees() {
        System.out.println("Listing all employees...");

        employeeDao.findAll().forEach(System.out::println);
    }
}
