package com.demo.configuration.level.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

public class FileReportWriter {

    public FileReportWriter() {
        System.out.println(getClass().getSimpleName() + ":: created");
    }
}
