package com.example.capstone.Controller;

import com.example.capstone.API.APIResponse;
import com.example.capstone.Model.Product;
import com.example.capstone.Service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    @GetMapping("/get")
    public ResponseEntity getProduct() {
        return ResponseEntity.status(200).body(productService.getProducts());
    }
    @PostMapping("/add")
    public ResponseEntity addProduct(@Valid @RequestBody Product product, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);}
        productService.addProduct(product);
            return ResponseEntity.status(200).body(new APIResponse("Successfully Added"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateProduct(@PathVariable String id, @Valid @RequestBody Product product, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated = productService.updateProduct(id,product);
        if (isUpdated) {
            return ResponseEntity.status(200).body(new APIResponse("Successfully Updated"));
        }
            return ResponseEntity.status(400).body(new APIResponse("Not found"));
        }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProduct(@PathVariable String id) {
        boolean isDeleted = productService.deleteProduct(id);
        if (isDeleted) {
            return ResponseEntity.status(200).body(new APIResponse("Successfully Deleted"));
        }
        return ResponseEntity.status(400).body(new APIResponse("Not found"));
    }












    }




