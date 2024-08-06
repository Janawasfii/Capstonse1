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




}



