package com.example.springrestdemo1.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String code;
    @Column(unique = true, nullable = false)
    private String firstName;
    private String lastName;
    @NotEmpty(message = "Address cannot be empty")
    private String address;
}
