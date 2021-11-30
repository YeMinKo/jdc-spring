package com.example.springdataassignment.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Cage {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;
    private String cageNo;
    private String location;

    @OneToOne( mappedBy = "cage", cascade = CascadeType.PERSIST)
    private Animal animal;

    public Cage() {}

    public Cage(String cageNo, String location) {
        this.cageNo = cageNo;
        this.location = location;
    }

    public void addAnimal(Animal animal) {
        animal.setCage(this);
        setAnimal(animal);
    }
}
