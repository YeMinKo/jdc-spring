package com.example.securitysalt.ds;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class RegisteringUser {

    @NotBlank(message = "Username cannot be empty")
    @Pattern(regexp = "[A-Za-z0-9]*", message = "Username contain illegal characters.")
    private String username;

    @NotBlank(message = "Password cannot be empty")
    @Pattern(regexp = "[A-Za-z0-9]*", message = "Pasword contain illegal characters.")
    private String password;

    @NotBlank(message = "Repeated password cannot be empty")
    @Pattern(regexp = "[A-Za-z0-9]*", message = "Repeated password contains illegal characters")
    private String repeatedPassword;
}
