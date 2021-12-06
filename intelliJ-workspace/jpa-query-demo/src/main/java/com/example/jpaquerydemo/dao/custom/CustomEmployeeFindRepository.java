package com.example.jpaquerydemo.dao.custom;

import com.example.jpaquerydemo.ds.Employee;

public interface CustomEmployeeFindRepository {

    Employee findByFirstNameAndLastName(String firstName, String lastName);
}
