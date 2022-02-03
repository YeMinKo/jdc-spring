package com.example.backend.dao;

import com.example.backend.ds.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomersDao extends CrudRepository<Customer, Integer> {
}
