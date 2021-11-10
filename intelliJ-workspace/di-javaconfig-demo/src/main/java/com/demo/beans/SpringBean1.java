package com.demo.beans;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SpringBean1 {

    private SpringBean2 springBean2;
    private SpringBean3 springBean3;

    public SpringBean1(SpringBean2 springBean2, SpringBean3 springBean3) {
        this.springBean2 = springBean2;
        this.springBean3 = springBean3;
        System.out.println(getClass().getSimpleName() + "::constructor.");
    }

    @Autowired
    public void setQuest(List<Quest> quests) {
        quests.stream()
                .map( q -> q.goQuest())
                .forEach(System.out::println);
    }

    public void sayHello() {
        System.out.println("Hello.");
    }
}
