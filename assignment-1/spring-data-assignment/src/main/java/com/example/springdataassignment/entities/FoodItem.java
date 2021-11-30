package com.example.springdataassignment.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class FoodItem {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private int quantity;

    @ManyToMany(mappedBy = "foodItems", cascade = CascadeType.PERSIST)
    private List<Animal> animals = new ArrayList<>();

    @ManyToOne
    private Supplier supplier;

    public FoodItem() {
    }

    public FoodItem(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public void addAnimal(Animal animal) {
        animal.getFoodItems().add(this);
        getAnimals().add(animal);
    }
}
