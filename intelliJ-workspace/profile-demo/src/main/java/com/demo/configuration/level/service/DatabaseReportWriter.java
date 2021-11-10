package com.demo.configuration.level.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

public class DatabaseReportWriter {

    public DatabaseReportWriter() {
        System.out.println(getClass().getSimpleName() + ":: created");
    }
}
