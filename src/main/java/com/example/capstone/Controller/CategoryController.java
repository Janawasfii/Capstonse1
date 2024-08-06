package com.example.capstone.Controller;

import com.example.capstone.API.APIResponse;
import com.example.capstone.Model.Category;
import com.example.capstone.Service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;


    @GetMapping("/get")
    public ResponseEntity getCategory() {
        return ResponseEntity.status(200).body(categoryService.getCategories());
    }
    @PostMapping("/add")
    public ResponseEntity addCategory(@Valid @RequestBody Category category, Errors errors) {
            if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);}
            categoryService.addCategories(category);
            return ResponseEntity.status(200).body(new APIResponse("Successfully added category"));}

    @PutMapping("/update/{categoryID}")
    public ResponseEntity updateCategory(@PathVariable String categoryID, @Valid @RequestBody Category category, Errors errors) {
            if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);}
            Boolean isUpdated = categoryService.updateCategory(categoryID, category);
            if (isUpdated) {
            return ResponseEntity.status(200).body(new APIResponse("Successfully updated category"));
            }
            return ResponseEntity.status(400).body(new APIResponse("Category not found"));}

    @DeleteMapping("/delete/{categoryID}")
    public ResponseEntity deleteCategory(@PathVariable String categoryID) {
        boolean isDeleted = categoryService.deleteCategory(categoryID);
        if (isDeleted) {
            return ResponseEntity.status(200).body(new APIResponse("Successfully deleted category"));}
            return ResponseEntity.status(400).body(new APIResponse("Category not found"));}


}
