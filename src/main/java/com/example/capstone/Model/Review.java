package com.example.capstone.Model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Review {

    @NotEmpty(message="Comment ID must not be empty")
    @Pattern(regexp = "^\\d{5}$")
    private String id;
    @NotEmpty(message="comment must not be empty")
    private String comment;
    @NotEmpty(message=" Product ID must not be empty")
    @Pattern(regexp = "^\\d{5}$")
    private String productId;
    @NotEmpty(message="User ID must not be empty")
    @Pattern(regexp = "^\\d{5}$")
    private String userID;
    @NotNull(message="Rating must not be null")
    @Max(5)
    private int rating;


}
