package com.example.responsestatusdemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.PAYMENT_REQUIRED, reason = "Custom Payment Required Error")
public class CustomPaymentRequiredException extends RuntimeException{
}
