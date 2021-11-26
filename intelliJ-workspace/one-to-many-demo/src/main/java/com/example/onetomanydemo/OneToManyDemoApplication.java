package com.example.onetomanydemo;

import com.example.onetomanydemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OneToManyDemoApplication implements CommandLineRunner {

    @Autowired
    private ProductService productService;

    public static void main(String[] args) {
        SpringApplication.run(OneToManyDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Create DB..........................................");
        productService.createDb();
        System.out.println("...................................................");

        System.out.println("Insert New Product to Category: ");
        productService.insertNewProductByCategoryName("Fruits");
        System.out.println("...................................................");

        System.out.println("Delete on First Product: ");
        productService.deleteFirstProduct();
        System.out.println("...................................................");

        System.out.println("Delete on Last Product: ");
        productService.deleteLastProduct();
        System.out.println("...................................................");

    }
}
