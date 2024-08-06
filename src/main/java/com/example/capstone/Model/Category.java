package com.example.capstone.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Category {
    @NotEmpty(message = "Category ID must not be empty")
    @Pattern(regexp = "^\\d{5}$")
    private String id;
    @NotEmpty(message="Category name must not be empty")
    @Pattern(regexp="^[a-zA-Z]*$",message ="Only characters")
    @Size(min=4,message="The length of category name must be more than 3")
    private String CategoryName;

}
