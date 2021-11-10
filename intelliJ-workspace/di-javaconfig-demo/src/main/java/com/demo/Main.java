package com.demo;

import com.demo.beans.SpringBean1;
import com.demo.beans.SpringBean4;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.registerShutdownHook();

        SpringBean1 springBean1 = context.getBean(SpringBean1.class);
        springBean1.sayHello();

//        SpringBean4 obj1 = context.getBean(SpringBean4.class);
//        SpringBean4 obj2 = context.getBean(SpringBean4.class);
//        SpringBean4 obj3 = context.getBean(SpringBean4.class);

//        System.out.println(obj1);
//        System.out.println(obj2);
//        System.out.println(obj3);
    }
}
