package com.example.preauthorizationdemo.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class NameService {

    private Map<String , List<String>> secretNames = Map.of(
            "john", List.of("Wild World", "Moon Pig"),
            "emma", List.of("Blue Mountain", "Spinning Tree")
    );

    @PreAuthorize("hasAuthority('write')")
    public String getName() {
        return "John William";
    }

    // name must be same as username
    @PreAuthorize("#name == authentication.principal.username")
    public List<String> getSecretNames(String name) {
        return secretNames.get(name);
    }
}
