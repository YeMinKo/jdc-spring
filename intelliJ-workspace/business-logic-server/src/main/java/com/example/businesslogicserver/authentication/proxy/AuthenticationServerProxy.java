package com.example.businesslogicserver.authentication.proxy;

import com.example.businesslogicserver.authentication.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AuthenticationServerProxy {

    private Logger logger = LoggerFactory.getLogger(AuthenticationServerProxy.class.getName());

    @Autowired
    private RestTemplate rest;

    @Value("${auth.server.base.url}")
    private String baseUrl;

    public void sendAuth(String username, String password) {
        logger.info("In sendAuth.....");
        String url = baseUrl + "/user/auth";
        var body = new User();
        body.setUsername(username);
        body.setPassword(password);

        var request = new HttpEntity<>(body);
        rest.postForEntity(url, request, Void.class);
    }

    public boolean sendOtp(String username, String code) {
        String url = baseUrl + "/otp/check";
        var body = new User();
        body.setUsername(username);
        body.setCode(code);

        var request = new HttpEntity<>(body);
        logger.info("In sentOtp path: " + url);
        var response = rest.postForEntity(url, request, Void.class);

        return response.getStatusCode().equals(HttpStatus.OK);
    }
}
