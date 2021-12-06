package com.example.jpaquerydemo.service;

import com.example.jpaquerydemo.dao.custom.CustomEmployeeDao;
import com.example.jpaquerydemo.dao.regular.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private CustomEmployeeDao customEmployeeDao;

    @Transactional
    public void queryEmployee() {
        System.out.println("Top 2 Employees By Salary");
        employeeDao.findTop3ByOrderBySalaryDesc().forEach(System.out::println);

        System.out.println("Searching for John Doe employee...");
        System.out.println(
                employeeDao.findByFirstNameAndLastName("John", "Doe")
        );

        System.out.println("Employee hired between 12 July 2020 and 19 July 2020");
        employeeDao.findByHireDateBetween(Date.valueOf("2020-07-12"), Date.valueOf("2020-07-19")).forEach(System.out::println);

        System.out.println("Employees order by hire date");
        employeeDao.findByOrderByHireDateDesc().forEach(System.out::println);

        System.out.println("All Employees");
        employeeDao.findAll().forEach(System.out::println);

        System.out.println();

        System.out.println("Searching for John Doe employee with custom dao");
        System.out.println(customEmployeeDao.findByFirstNameAndLastName("John", "Doe"));
    }
}
