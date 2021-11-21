package com.demo;

import com.demo.dao.StudentDao;
import com.demo.entities.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPU");
        EntityManager em = emf.createEntityManager();

        StudentDao obj = new StudentDao(em);
        obj.createStudent("John Doe", LocalDate.now(), "ISY");
        obj.createStudent("John Wiliam", LocalDate.now(), "ISM");
        obj.createStudent("Thomas", LocalDate.now(), "USA");

        obj.updateStudentName("Larrey Jaken", 2);
        obj.deleteStudent(1);

        System.out.println("Name: " + obj.findStudentById(3).getName());

//        EntityTransaction tx = em.getTransaction();
//
//        Student s1 = new Student("Thaw Thaw", LocalDate.of(2000, 3, 22), "ISY");
//        Student s2 = new Student("Thaw Thaw Htun Zin", LocalDate.of(2000, 5, 22), "ISM");
//        Student s3 = new Student("Thu Thu Thaw", LocalDate.of(2000, 1, 22), "Latha");
//
//        tx.begin();
//        em.persist(s1);
//        em.persist(s2);
//        em.persist(s3);
//        tx.commit();



        em.close();
        emf.close();
    }
}
