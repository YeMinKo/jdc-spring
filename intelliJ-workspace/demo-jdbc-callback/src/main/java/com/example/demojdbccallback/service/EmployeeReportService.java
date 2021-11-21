package com.example.demojdbccallback.service;

import com.example.demojdbccallback.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeReportService {

    @Autowired
    private EmployeeDao employeeDao;

    public void printReport() {
        System.out.println("Employee Report Start.");

        System.out.println("Employee List: ");
        employeeDao.findEmployees()
                        .forEach(System.out::println);

        System.out.println("Employee Average Salary Calculated Row by Row.");
        System.out.println(employeeDao.findAverageSalaryRowByRow());

        System.out.println("Employee Average Salary Calculated on Entire Result Set.");
        System.out.println(employeeDao.findAverageSalaryCalculatedOnEntireResultSet());

        System.out.println("Employee Average Salary Sql Level.");
        System.out.println(employeeDao.findAverageSalarySqlLevel());

        System.out.println("Employee Average Salary Modern Stream API");
        System.out.println(employeeDao.findAverageSalaryModernImplementation());

        System.out.println("Employee Id found based on email.");
        System.out.println(employeeDao.findEmployeeIdFromEmail("shayles@gmail.com"));

        System.out.println("Employee Report Stop.");
    }
}
