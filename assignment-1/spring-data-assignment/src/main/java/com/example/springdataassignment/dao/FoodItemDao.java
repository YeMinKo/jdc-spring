package com.example.springdataassignment.dao;

import com.example.springdataassignment.entities.FoodItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodItemDao extends CrudRepository<FoodItem, Integer> {
}
