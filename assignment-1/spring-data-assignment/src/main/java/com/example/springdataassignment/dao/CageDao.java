package com.example.springdataassignment.dao;

import com.example.springdataassignment.entities.Cage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CageDao extends CrudRepository<Cage, Integer> {
}
