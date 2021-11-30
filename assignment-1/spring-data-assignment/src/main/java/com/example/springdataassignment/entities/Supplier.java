package com.example.springdataassignment.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Supplier {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;
    private String supplierName;
    private String contactNo;
    private String address;

    public Supplier() {
    }

    public Supplier(String supplierName, String contactNo, String address) {
        this.supplierName = supplierName;
        this.contactNo = contactNo;
        this.address = address;
    }
}
