package com.example.securitysalt.dao;

import com.example.securitysalt.ds.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomersDao extends CrudRepository<Customer, Integer> {
}
