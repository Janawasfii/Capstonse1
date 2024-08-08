package com.example.capstone.Controller;

import com.example.capstone.API.APIResponse;
import com.example.capstone.Model.User;
import com.example.capstone.Service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("/get")
    public ResponseEntity getUser() {
        return ResponseEntity.status(200).body(userService.getUsers());
    }
    @PostMapping("/add")
    public ResponseEntity addUser(@Valid @RequestBody User user, Errors errors) {
        if (errors.hasErrors()) {
         return ResponseEntity.status(400).body(errors.getAllErrors());}
        userService.addUsers(user);
        return ResponseEntity.status(200).body(new APIResponse("User added successfully"));}

    @PutMapping("/update/{userID}")
    public ResponseEntity updateUser(@PathVariable String userID,@Valid @RequestBody User user, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getAllErrors());}
            boolean isUpdated = userService.updateUser(userID,user);
        if (isUpdated) {
            return ResponseEntity.status(200).body(new APIResponse("User updated successfully"));}
            return ResponseEntity.status(400).body(new APIResponse("User not found"));}

    @DeleteMapping("/delete/{userID}")
    public ResponseEntity deleteUser(@PathVariable String userID) {
        boolean isDeleted = userService.deleteUser(userID);
        if (isDeleted) {
            return ResponseEntity.status(200).body(new APIResponse("User deleted successfully"));
        }
        return ResponseEntity.status(400).body(new APIResponse("User not found"));
    }
    @PutMapping("/set/{UserID}/{ProductID}/{MerchantID}/{MerchantStockID}")
    public ResponseEntity buyProduct(@PathVariable String UserID,@PathVariable String ProductID,@PathVariable String MerchantID) {
        int isSet = userService.buyProduct(UserID,ProductID,MerchantID);
        if (isSet==1) {
            return ResponseEntity.status(400).body(new APIResponse("Out of stock"));
        }if(isSet==3){
            return ResponseEntity.status(400).body(new APIResponse("Balance is less than the product price"));
        }   if(isSet == 4){
            return ResponseEntity.status(400).body(new APIResponse("Not found"));}

        return ResponseEntity.status(200).body(new APIResponse("Successfully set"));
    }


    @DeleteMapping("/delete/{userID}/{productID}/{comment}")
    public ResponseEntity deleteBadComment(@PathVariable String userID, @PathVariable String productID, @PathVariable String comment) {
        boolean isDeleted = userService.deleteBadComment(userID, productID, comment);
        if (isDeleted) {
            return ResponseEntity.status(200).body(new APIResponse("Successfully deleted comment"));
        }
        return ResponseEntity.status(400).body(new APIResponse("Review not found"));
    }




}



