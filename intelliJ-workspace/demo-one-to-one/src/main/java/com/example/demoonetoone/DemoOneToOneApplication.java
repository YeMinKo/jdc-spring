package com.example.demoonetoone;

import com.example.demoonetoone.entities.Address;
import com.example.demoonetoone.entities.Customer;
import com.example.demoonetoone.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;

@SpringBootApplication
public class DemoOneToOneApplication implements CommandLineRunner {

    @Autowired
    private CustomerService customerService;

    public static void main(String[] args) {
        SpringApplication.run(DemoOneToOneApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        customerService.createDb();

        Customer customer = customerService.findCustomerById(1);
        System.out.println(String.format("Name: %s : StreetName: %s", customer.getName(), customer.getAddress().getStreetName()));

        Address address = customerService.findAddressById(1);
        System.out.println(String.format("Name: %s : StreetName %s", address.getCustomer().getName(), address.getStreetName()));
    }
}
