package com.example.capstone.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    @NotEmpty(message=" Product ID must not be empty")
    @Pattern(regexp = "^\\d{5}$")
    private String id;
    @NotEmpty(message="Product name must not be empty")
    @Pattern(regexp="^[a-zA-Z]*$",message ="Only characters")
    @Size(min=4,message="The length of product must be more than 3")
    private String productName;
    @NotNull(message="Product price should not be empty")
    @Positive(message="Product price must be positive number")
    private double productPrice;
    @NotEmpty(message="Category ID must not be empty")
    @Pattern(regexp = "^\\d{3}$")
    private String categoryID;

}
