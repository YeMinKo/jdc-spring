package com.example.democompositeprimarykey.service;

import com.example.democompositeprimarykey.dao.DepartmentDao;
import com.example.democompositeprimarykey.dao.EmployeesDao;
import com.example.democompositeprimarykey.entities.Department;
import com.example.democompositeprimarykey.entities.DepartmentId;
import com.example.democompositeprimarykey.entities.Employee;
import com.example.democompositeprimarykey.entities.EmployeeId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {

    @Autowired
    private DepartmentDao departmentDao;
    @Autowired
    private EmployeesDao employeesDao;

    @Transactional
    public void createDb() {
        Department department1 = new Department("M102", "Yangon", "Marketing");
        Department department2 = new Department("S103", "Yangon", "Sales");

        Employee e1 = new Employee(new EmployeeId("ygn", "sbn123"), "Thaw Thaw", 30000);
        Employee e2 = new Employee(new EmployeeId("ygn", "sbn456"), "John Doe", 320000);
        Employee e3 = new Employee(new EmployeeId("ygn", "sbn125"), "James", 23000);
        Employee e4 = new Employee(new EmployeeId("ygn", "sbn143"), "Thomas", 60000);

        Employee me1 = employeesDao.save(e1);
        Employee me2 = employeesDao.save(e2);

        Employee me3 = employeesDao.save(e3);
        Employee me4 = employeesDao.save(e4);

        department1.getEmployees().add(me1);
        me1.setDepartment(departmentDao.save(department1));

        department1.getEmployees().add(me2);
        me2.setDepartment(departmentDao.save(department1));

        department2.getEmployees().add(me3);
        me3.setDepartment(departmentDao.save(department2));

        department2.getEmployees().add(me4);
        me4.setDepartment(departmentDao.save(department2));
    }

    @Transactional
    public Department findDepartmentById(DepartmentId departmentId) {
        return departmentDao.findById(departmentId).get();
    }
}
