package com.example.springrestdemo1.controller;

import com.example.springrestdemo1.dao.CustomerDao;
import com.example.springrestdemo1.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.util.stream.Collectors;

@RestController
public class CustomerController {

    @Autowired
    private CustomerDao customerDao;

    // curl -X GET http://localhost:8080/customers
    @GetMapping("/customers")
    public Iterable<Customer> list() {
        return customerDao.findAll();
    }

    // curl -X GET http://localhost:8080/customers/1
    @GetMapping("/customers/{id}")
    public Customer get(@PathVariable int id) {
        return customerDao.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    // curl -X POST -v -H 'Content-Type: application/json' -d '{"code":"JD","firstName":"John","lastName":"Doe","address":"200 Notornwood Dr.Olympia, WA 89977"}' http://localhost:8080/customers
    @PostMapping("/customers")
    public ResponseEntity<Customer> create(@RequestBody Customer customer, BindingResult bindingResult) {
        if(!bindingResult.hasErrors()) {
            Customer savedCustomer = customerDao.save(customer);
            return ResponseEntity
                    .created(URI.create("/customers/" + savedCustomer.getId()))
                    .body(savedCustomer);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("Request contains incorrect data=[%s]",
                    getErrors(bindingResult)));
        }
    }

    // curl -X PUT -v -H 'Content-Type: application/json' -d '{"code":"FD","firstName":"John","lastName":"Freeman","address":"200 Notornwood Dr.Olympia, WA 89977"}' http://localhost:8080/customers/6
    @PutMapping("/customers/{id}")
    public ResponseEntity<Customer> update(@RequestBody Customer customer, @PathVariable int id,BindingResult bindingResult) {
        if(!bindingResult.hasErrors()) {
            if(customerDao.existsById(id)) {
                customer.setId(id);
                Customer savedCustomer = customerDao.save(customer);
                return ResponseEntity
                        .ok(savedCustomer);
            } else {
                return ResponseEntity.notFound().build();
            }
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("Request contains incorrect data = [%s]",
                    getErrors(bindingResult)));
        }
    }

    // curl -X DELETE -v http://localhost:8080/customers/3
    @DeleteMapping("/customers/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        if(customerDao.existsById(id)) {
            customerDao.deleteById(id);

            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    private String getErrors(BindingResult bindingResult) {
        return bindingResult.getAllErrors().stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.joining(", "));
    }
}
