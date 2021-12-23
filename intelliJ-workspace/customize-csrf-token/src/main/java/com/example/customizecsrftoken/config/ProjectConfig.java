package com.example.customizecsrftoken.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfTokenRepository;

@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CsrfTokenRepository customCsrfTokenRepository; // Alias name is used! Must same as CustomCsrfTokenRepository class name.

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf(
                c -> {
                    c.csrfTokenRepository(customCsrfTokenRepository);
                    c.ignoringAntMatchers("/mary");
                }
        );
        http.authorizeHttpRequests()
                .anyRequest()
                .permitAll();
    }
}
