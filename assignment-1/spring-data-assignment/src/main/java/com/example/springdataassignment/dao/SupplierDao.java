package com.example.springdataassignment.dao;

import com.example.springdataassignment.entities.Supplier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierDao extends CrudRepository<Supplier, Integer> {
}
