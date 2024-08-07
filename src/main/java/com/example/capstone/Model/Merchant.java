package com.example.capstone.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Merchant {
    @NotEmpty(message="Merchant ID must not be empty")
    @Pattern(regexp = "^\\d{5}$")
    private String id;
    @NotEmpty(message ="Merchant name must not be empty")
    @Size(min=4,message="The length of merchant name must be more than 3")
    private String merchantName;
    @NotEmpty(message="Status should not be empty")
    @Pattern(regexp="^(PLACED|PROCESSING|SHIPPED|DELIVERED)$",message = "Only 4 options(PLACED or PROCESSING or SHIPPED or DELIVERED)")
    private String status;
    @NotEmpty(message="Order ID must not be empty")
    @Pattern(regexp = "^\\d{3}$")
    private String orderId;





}
