package com.example.springdataassignment.service;

import com.example.springdataassignment.dao.CageDao;
import com.example.springdataassignment.dao.CategoryDao;
import com.example.springdataassignment.dao.FoodItemDao;
import com.example.springdataassignment.dao.SupplierDao;
import com.example.springdataassignment.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AnimalService {

    @Autowired
    CageDao cageDao;

    @Autowired
    CategoryDao categoryDao;

    @Autowired
    FoodItemDao foodItemDao;

    @Autowired
    SupplierDao supplierDao;

    @Transactional
    public void createDb() {

        // Animal Entity
        Animal animal1 = new Animal("Mammal", 5);
        Animal animal2 = new Animal("Birds", 10);
        Animal animal3 = new Animal("Mammal", 30);
        Animal animal4 = new Animal("Birds", 10);

        // Cage Entity
        Cage cage1 = new Cage("A1", "Building 1");
        Cage cage2 = new Cage("A2", "Building 1");
        Cage cage3 = new Cage("B1", "Building 2");
        Cage cage4 = new Cage("B2", "Building 2");

        // Category Entity
        Category category1 = new Category("Mammal");
        Category category2 = new Category("Birds");

        // FoodItem Entity
        FoodItem foodItem1 = new FoodItem("Apple", 1000);
        FoodItem foodItem2 = new FoodItem("Grapes", 1000);

        // Supplier Entity
        Supplier supplier = new Supplier("John Doe", "55-555-555", "Ygn");

        // Supplier Managed
        supplierDao.save(supplier);

        // Category Managed
        categoryDao.save(category1);
        categoryDao.save(category2);

        // Mapping Animal with Category (Uni direction - ManyToOne)
        animal1.setCategory(category1);
        animal2.setCategory(category1);
        animal3.setCategory(category2);
        animal4.setCategory(category2);

        // Mapping Cage and Animal (Bi direction- OneToOne)
        cage1.addAnimal(animal1);
        cage2.addAnimal(animal2);
        cage3.addAnimal(animal3);
        cage4.addAnimal(animal4);

        // Mapping FoodItem and Animal (Bi direction - ManyToMany)
        foodItem1.addAnimal(animal1);
        foodItem1.addAnimal(animal2);
        foodItem1.addAnimal(animal3);
        foodItem1.addAnimal(animal4);

        // Mapping FoodItem and Animal (Bi direction - ManyToMany)
        foodItem2.addAnimal(animal1);
        foodItem2.addAnimal(animal2);
        foodItem2.addAnimal(animal3);
        foodItem2.addAnimal(animal4);

        // Mapping FoodItem with Supplier ( Uni direction - ManyToOne)
        foodItem1.setSupplier(supplier);
        foodItem2.setSupplier(supplier);

        // FoodItem Managed
        foodItemDao.save(foodItem1);
        foodItemDao.save(foodItem2);

        // Cage Managed
        cageDao.save(cage1);
        cageDao.save(cage2);
        cageDao.save(cage3);
        cageDao.save(cage4);
    }
}
