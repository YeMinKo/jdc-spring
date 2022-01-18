package com.example.securitysalt.dao;

import com.example.securitysalt.ds.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentsDao extends CrudRepository<Department, Integer> {
}
