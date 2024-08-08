package com.example.capstone.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class User {

   @NotEmpty(message="User ID must not be empty")
   @Pattern(regexp = "^\\d{5}$")
    private String id;
    @NotEmpty(message="User name must not be empty")
    @Pattern(regexp="^[a-zA-Z]*$",message ="Only characters")
    @Size(min=6,message="The length of product must be more than 5")
    private String userName;
    @NotEmpty(message = "Password must not be empty")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{7,}$")
    private String password;
    @NotEmpty(message="Email must not be empty")
    @Email
    private String email;
    @NotEmpty(message="Role must not be empty")
    @Pattern(regexp="^(Admin|Customer)$",message = "Only 2 options(Admin or Customer)")
    private String role;
    @NotNull(message="Balance must not be empty")
    @Positive(message="Balance should be a positive number")
    private double balance;
//   @NotEmpty(message="comment must not be empty")
//  private String comment;


}
