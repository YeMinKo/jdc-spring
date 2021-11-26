package com.example.demomanytomany.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String grade;
    private String school;

    @ManyToMany(cascade = CascadeType.PERSIST, mappedBy = "students")
    private List<Subject> subjects = new ArrayList<>();

    public void addSubject(Subject subject) {
        subject.getStudents().add(this);
        subjects.add(subject);
    }

    public Student() {
    }

    public Student(String name, String grade, String school) {
        this.name = name;
        this.grade = grade;
        this.school = school;
    }
}
