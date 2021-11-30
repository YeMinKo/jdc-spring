package com.example.springdataassignment.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Animal {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;
    private String type;
    private int totalNumber;

    @OneToOne
    private Cage cage;

    @ManyToOne
    private Category category;

    @ManyToMany
    private List<FoodItem> foodItems = new ArrayList<>();

    public Animal() {}

    public Animal(String type, int totalNumber) {
        this.type = type;
        this.totalNumber = totalNumber;
    }
}
