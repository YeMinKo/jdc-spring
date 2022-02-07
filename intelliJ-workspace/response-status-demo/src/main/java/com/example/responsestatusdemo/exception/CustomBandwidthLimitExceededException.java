package com.example.responsestatusdemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BANDWIDTH_LIMIT_EXCEEDED, reason = "Custom Bandwidth Limit Exception")
public class CustomBandwidthLimitExceededException extends RuntimeException{
}
