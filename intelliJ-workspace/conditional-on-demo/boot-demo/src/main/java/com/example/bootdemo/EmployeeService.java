package com.example.bootdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class EmployeeService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void printEmails() {
        System.out.println("Fetching employees e-mails");
        jdbcTemplate.queryForList("select email from employee", String.class)
                .forEach(System.out::println);
    }
}
