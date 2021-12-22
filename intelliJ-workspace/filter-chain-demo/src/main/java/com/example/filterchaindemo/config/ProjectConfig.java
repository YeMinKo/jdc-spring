package com.example.filterchaindemo.config;

import com.example.filterchaindemo.filters.AuthenticationLoggingFilter;
import com.example.filterchaindemo.filters.RequestValidationFilter;
import com.example.filterchaindemo.filters.StaticKeyAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private StaticKeyAuthenticationFilter filter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.addFilterAt(filter,
                BasicAuthenticationFilter.class
                )
                .authorizeHttpRequests()
                .anyRequest()
                .permitAll();

//        http.addFilterBefore(
//                new RequestValidationFilter(),
//                BasicAuthenticationFilter.class
//        ).addFilterAfter( new AuthenticationLoggingFilter(),
//                BasicAuthenticationFilter.class
//        ).authorizeHttpRequests()
//                .anyRequest().permitAll();
    }
}
