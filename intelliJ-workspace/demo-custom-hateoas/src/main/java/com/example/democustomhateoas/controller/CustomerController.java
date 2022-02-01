package com.example.democustomhateoas.controller;

import com.example.democustomhateoas.dao.AddressDao;
import com.example.democustomhateoas.dao.CustomerDao;
import com.example.democustomhateoas.ds.Customer;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
public class CustomerController {

    public static final Class<CustomerController> CONTROLLER_CLASS = CustomerController.class;

    private final CustomerDao customerDao;

    private final AddressDao addressDao;

    public CustomerController(CustomerDao customerDao, AddressDao addressDao) {
        this.customerDao = customerDao;
        this.addressDao = addressDao;
    }

    @GetMapping("/customers/{id}")
    public EntityModel<Customer> getCustomer(@PathVariable int id) {
        Optional<Customer> customer = customerDao.findById(id);
        if(!customer.isPresent()) {
            throw new EntityNotFoundException("id-" + id);
        }

        EntityModel<Customer> resource = EntityModel.of(customer.get());
        resource.add(linkTo(methodOn(CONTROLLER_CLASS).getCustomer(id)).withSelfRel());
        resource.add(linkTo(methodOn(CONTROLLER_CLASS).getCustomer(id)).withRel("customer"));
        return resource;
    }

    @GetMapping("/customers")
    public CollectionModel<EntityModel<Customer>> listCustomers() {
        List<EntityModel<Customer>> customerEntityModel =
                StreamSupport.stream(customerDao.findAll().spliterator(), false)
                        .map( customer -> EntityModel.of(customer, linkTo(methodOn(CONTROLLER_CLASS).getCustomer(customer.getId())).withSelfRel(),
                                linkTo(methodOn(CONTROLLER_CLASS).getCustomer(customer.getId())).withRel("customer")
                                ))
                        .collect(Collectors.toList());
        Link customersLink = linkTo(methodOn(CONTROLLER_CLASS).listCustomers()).withSelfRel();
        return CollectionModel.of(customerEntityModel, customersLink);
    }
}
