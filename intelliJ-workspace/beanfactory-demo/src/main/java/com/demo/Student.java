package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Student {

    private String name;
    private int age;
    private String school;

    @Autowired
    private Address address;

    public Student() {}

    public Student(String name, int age, String school) {
        this.name = name;
        this.age = age;
        this.school = school;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSchool() {
        return school;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String studentInfo() {
        return String.format(
                "Name: %s == StreetName: %s",
                name,
                address.getStreetName()
        );
    }
}
