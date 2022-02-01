package com.example.democustomhateoas.dao;

import com.example.democustomhateoas.ds.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressDao extends CrudRepository<Address, Integer> {
}
