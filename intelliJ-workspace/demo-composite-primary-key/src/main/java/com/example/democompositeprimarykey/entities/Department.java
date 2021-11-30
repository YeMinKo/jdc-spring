package com.example.democompositeprimarykey.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@IdClass(DepartmentId.class)
public class Department {

    @Id
    private String departmentCode;

    @Id
    private String departmentBranch;

    private String name;

    @OneToMany( mappedBy = "department")
    private List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee emp) {
        emp.setDepartment(this);
        employees.add(emp);
    }

    public Department() {
    }

    public Department(String departmentCode, String departmentBranch, String name) {
        this.departmentCode = departmentCode;
        this.departmentBranch = departmentBranch;
        this.name = name;
    }
}
