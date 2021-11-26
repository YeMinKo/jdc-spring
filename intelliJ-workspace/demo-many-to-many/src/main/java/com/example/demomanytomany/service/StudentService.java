package com.example.demomanytomany.service;

import com.example.demomanytomany.entities.Student;
import com.example.demomanytomany.entities.Subject;
import com.example.demomanytomany.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Transactional
    public void createDb() {
        Student s1 = new Student("John Doe", "11", "ISM");
        Student s2 = new Student("John Willian", "12", "ISM");
        Student s3 = new Student("John Wick", "10", "ISY");

        Subject sub1 = new Subject("CS-50", "3 months");
        Subject sub2 = new Subject("AI", "6 months");
        Subject sub3 = new Subject("Python", "12 months");

        // mapping
        s1.addSubject(sub1);
        s1.addSubject(sub2);
        s1.addSubject(sub3);

        s2.addSubject(sub1);

        s3.addSubject(sub1);
        s3.addSubject(sub3);

        studentRepository.save(s1);
        studentRepository.save(s2);
        studentRepository.save(s3);
    }
}
