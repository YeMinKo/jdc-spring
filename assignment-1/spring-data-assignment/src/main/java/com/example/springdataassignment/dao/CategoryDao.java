package com.example.springdataassignment.dao;

import com.example.springdataassignment.entities.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryDao extends CrudRepository<Category, Integer> {
}
