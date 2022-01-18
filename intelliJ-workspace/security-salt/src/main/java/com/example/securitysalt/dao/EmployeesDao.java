package com.example.securitysalt.dao;

import com.example.securitysalt.ds.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeesDao extends CrudRepository<Employee, Integer> {
}
