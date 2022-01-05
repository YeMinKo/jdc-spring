package com.example.preauthorizationdemo.service;

import com.example.preauthorizationdemo.model.Employee;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BookService {

    private Map<String, Employee> records =
            Map.of(
                    "emma", new Employee("Emma Thompson",
                            List.of("A Tale of Two Cities", "A Pale View of Hill"),
                            List.of("reader")),
                    "john", new Employee("John William",
                            List.of("The Mountain is Young", "The Remains of the day"),
                            List.of("researcher"))
            );

    @PostAuthorize("returnObject.roles.contains('reader')")
    public Employee getBookDetail(String name) {
        return records.get(name);
    }
}
