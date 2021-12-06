package com.example.jpaquerydemo.dao.custom;

import com.example.jpaquerydemo.ds.Employee;
import org.springframework.data.repository.CrudRepository;

public interface CustomEmployeeDao extends CrudRepository<Employee, Integer>, CustomEmployeeFindRepository {
}
