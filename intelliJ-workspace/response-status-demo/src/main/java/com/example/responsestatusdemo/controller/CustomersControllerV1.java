package com.example.responsestatusdemo.controller;
import com.example.responsestatusdemo.exception.CustomBadRequestException;
import com.example.responsestatusdemo.ds.Customer;
import com.example.responsestatusdemo.exception.CustomBandwidthLimitExceededException;
import com.example.responsestatusdemo.exception.CustomPaymentRequiredException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomersControllerV1 {

    // curl -i http://localhost:8090/api/v1/customerA
    @GetMapping("/api/v1/customerA")
    public Customer getCustmerA() {
        throw new CustomBadRequestException();
    }

    // curl -i http://localhost:8090/api/v1/customerB
    @GetMapping("/api/v1/customerB")
    public Customer getCutomerB() {
        throw new CustomPaymentRequiredException();
    }

    // curl -i http://localhost:8090/api/v1/customerC
    @GetMapping("/api/v1/customerC")
    public Customer getCustomerC() {
        throw new CustomBandwidthLimitExceededException();
    }
}
