package com.example.democompositeprimarykey.dao;

import com.example.democompositeprimarykey.entities.Employee;
import com.example.democompositeprimarykey.entities.EmployeeId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeesDao extends CrudRepository<Employee, EmployeeId> {
}
