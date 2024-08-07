package com.example.capstone.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MerchantStock {
    @NotEmpty(message="Merchant stock ID must not be empty")
    @Pattern(regexp = "^\\d{5}$")
    private String id;
    @NotEmpty(message=" Product ID must not be empty")
    @Pattern(regexp = "^\\d{5}$")
    private String productID;
    @NotEmpty(message="Merchant ID must not be empty")
    @Pattern(regexp = "^\\d{5}$")
    private String merchantID;
    @NotNull(message="Stock must not be empty")
    @Min(11)
    private int stock;










}
