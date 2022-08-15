package com.example.amazon;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;

@AllArgsConstructor @Data
public class User {
    @NotNull(message = "id cant be null")
    @Size(min = 3 , message = "id length must be more than 2")
    private String UserId;

    @NotEmpty(message = "username can't be empty")
    @Size(min = 5,max = 10,message = "username must be more than 5 char and less than 10 char")
    private String UserName;

    @NotEmpty(message = "password can't be empty")
    @Size(min = 6,max = 15,message = "password must be more than 5 char and less than 15 char")
    @Pattern(regexp = "^(?=.*\\d).{6,16}$",message = "please enter strong password")
    private String password;

    @NotEmpty(message = "email can't be empty")
    @Email(message = "Please enter a valid email")
    private String email;

    @NotEmpty(message = "role can't be empty")
    @Pattern(regexp = "(Admin|Customer)",message = "Role must be in admin or Customer only")
    private String role;

    @Pattern(regexp = "^\\d{0,8}(\\.\\d{1,4})?$",message="balance must be a positive number")
    @Range(min = 1,max = 9 , message = "balance length must be more than 1 and less than 9")
    private int balance;

}
