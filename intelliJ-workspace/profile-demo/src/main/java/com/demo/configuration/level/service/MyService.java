package com.demo.configuration.level.service;

import org.springframework.stereotype.Component;

public class MyService {
    public MyService() {
        System.out.println(getClass().getSimpleName() + ":: created.");
    }
}
