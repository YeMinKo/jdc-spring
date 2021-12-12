package com.example.bootdemo;

import com.demo.filestore.FileStore;
import com.demo.java.JavaEnvInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootDemoApplication implements CommandLineRunner {

    @Autowired
    private JavaEnvInfo javaEnvInfo;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private FileStore fileStore;

    public static void main(String[] args) {
        SpringApplication.run(BootDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        javaEnvInfo.printJvmEnvInfo();
        fileStore.printFileStoreInfo();

        employeeService.printEmails();
    }
}
