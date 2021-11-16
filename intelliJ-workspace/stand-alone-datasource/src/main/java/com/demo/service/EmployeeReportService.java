package com.demo.service;

import com.demo.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeReportService {

    @Autowired
    private EmployeeDao employeeDao;

    public void printReport() {
        System.out.println("Employee Report Start.");
        System.out.println("Find Employees emails.");
        employeeDao.findEmployeeEmails().forEach(System.out::println);

        System.out.println("Highest Salary Employee");
        System.out.println(employeeDao.findEmployeeWithHighestSalary());
        System.out.println("Employees Count");
        System.out.println(employeeDao.findEmployeesCount());

        System.out.println("Find All Employees.");
        employeeDao.findAllEmployees().forEach(System.out::println);

        System.out.println("Employee Report Stop.");
    }
}
