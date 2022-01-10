package com.example.springsecuritymodel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSecurityModelApplication {

    // Spring Security Code Places to analyze:
    // DelegatingFilterProxy.doFilter
    // FilterChainProxy.doFilterInternal
    // ProviderManager.authenticate
    // AffirmativeBased.decide
    // RoleVoter.vote

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityModelApplication.class, args);
    }

}
