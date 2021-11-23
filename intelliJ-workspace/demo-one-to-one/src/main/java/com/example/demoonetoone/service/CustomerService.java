package com.example.demoonetoone.service;

import com.example.demoonetoone.dao.AddressDao;
import com.example.demoonetoone.dao.CustomerDao;
import com.example.demoonetoone.entities.Address;
import com.example.demoonetoone.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CustomerService {

    @Autowired
    private AddressDao addressDao;
    @Autowired
    private CustomerDao customerDao;

    @Transactional
    public void createDb() {
        Customer customer1 = new Customer("Mg Mg", "Reading");
        Customer customer2 = new Customer("Soe Soe", "Swimming");

        Address address1 = new Address("Love Lane", "Ygn", "111111");
        Address address2 = new Address("Dream Land", "Ygn", "222222");

        // Because of Bidirection
        address1.setCustomer(customer1);
        address2.setCustomer(customer2);
        customer1.setAddress(address1);
        customer2.setAddress(address2);


        addressDao.save(address1);
        addressDao.save(address2);
        customerDao.save(customer1);
        customerDao.save(customer2);
    }

    @Transactional
    public Customer findCustomerById(int customerId) {
        return customerDao.getById(customerId);
    }

    @Transactional
    public Address findAddressById(int addressId) {
        return addressDao.getById(addressId);
    }

}
