package com.example.prepostauthorizationdemo.config;

import com.example.prepostauthorizationdemo.model.Document;
import com.example.prepostauthorizationdemo.security.DocumentPermissionEvaluator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ProjectConfig extends GlobalMethodSecurityConfiguration {

    @Autowired
    private DocumentPermissionEvaluator evaluator;

    @Override
    protected MethodSecurityExpressionHandler createExpressionHandler() {
        var expressionHandler =
                new DefaultMethodSecurityExpressionHandler();
        expressionHandler.setPermissionEvaluator(evaluator);
        return expressionHandler;
    }

    @Bean
    public UserDetailsService userDetailsService() {
        var service = new InMemoryUserDetailsManager();
        var u1 = User.withUsername("john")
                .password("12345")
                .authorities("manager")
                .build();

        var u2 = User.withUsername("emma")
                .password("12345")
                .authorities("admin")
                .build();

        var u3 = User.withUsername("natalie")
                .password("12345")
                .authorities("manager")
                .build();

        service.createUser(u1);
        service.createUser(u2);
        service.createUser(u3);
        return service;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
