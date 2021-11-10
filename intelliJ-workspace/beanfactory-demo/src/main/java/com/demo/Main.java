package com.demo;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
//        Student student = new Student("Thaw Thaw", 22, "ISY");
//        System.out.println("Name: " + student.getName());
//        System.out.println("Age: " + student.getAge());
//        System.out.println("School: " + student.getSchool());

        AnnotationConfigApplicationContext beanFactory = new AnnotationConfigApplicationContext(JavaConfig.class);
        beanFactory.registerShutdownHook();
        Student student = beanFactory.getBean("student", Student.class);
        student.setName("Willion");
        student.setAge(20);
        student.setSchool("ISM");

        System.out.println("Name: " + student.getName());
        System.out.println("Age: " + student.getAge());
        System.out.println("School: " + student.getSchool());

//        student.setAddress(new Address()); // writing controls
        System.out.println(student.studentInfo());

//        ((AnnotationConfigApplicationContext) beanFactory).close();
    }
}
