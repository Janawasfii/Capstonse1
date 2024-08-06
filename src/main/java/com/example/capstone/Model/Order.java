package com.example.capstone.Model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Order {

    @NotEmpty(message="Order ID must not be empty")
    @Pattern(regexp = "^\\d{3}$")
    private String id;
    @NotEmpty(message="User ID must not be empty")
    @Pattern(regexp = "^\\d{5}$")
    private String userID;
    @NotEmpty(message=" Product ID must not be empty")
    @Pattern(regexp = "^\\d{5}$")
    private String productID;
    @NotEmpty(message="Status should not be empty")
    @Pattern(regexp="^(PLACED|PROCESSING|SHIPPED|DELIVERED)$",message = "Only 4 options(PLACED or PROCESSING or SHIPPED or DELIVERED)")
    private String status;


}
