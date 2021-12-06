package com.example.jpaquerydemo.dao.regular;

import com.example.jpaquerydemo.ds.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface EmployeeDao extends CrudRepository<Employee, Integer> {

    List<Employee> findTop3ByOrderBySalaryDesc();

    List<Employee> findByHireDateBetween(Date min, Date max);

    List<Employee> findByOrderByHireDateDesc();

//    Employee findByFirstNameAndLastName(String firstName, String lastName);

    @Query("select e from Employee e where e.firstName = ?1 and e.lastName = ?2")
    Employee findByFirstNameAndLastName(String firstName, String lastName);
}
