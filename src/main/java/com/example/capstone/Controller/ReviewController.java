package com.example.capstone.Controller;

import com.example.capstone.API.APIResponse;
import com.example.capstone.Model.Product;
import com.example.capstone.Model.Review;
import com.example.capstone.Model.User;
import com.example.capstone.Service.ProductService;
import com.example.capstone.Service.ReviewService;
import com.example.capstone.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/v1/review")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping("/get")
    public ResponseEntity getReviews() {
        return ResponseEntity.ok(reviewService.getReviews());
    }

    @PostMapping("/add")
    public ResponseEntity addReview(@PathVariable String userID, @PathVariable String productId,@Valid @RequestBody Review review, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        reviewService.addReview(userID,productId,review);
        return ResponseEntity.status(200).body(new APIResponse("Successfully added review"));
    }

    @PutMapping("/update/{reviewID}")
    public ResponseEntity updateReview(@PathVariable String reviewID, @Valid @RequestBody Review review, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated = reviewService.updateReview(reviewID, review);
        if (isUpdated) {
            return ResponseEntity.status(200).body(new APIResponse("Successfully updated review"));
        }
        return ResponseEntity.status(400).body(new APIResponse("Review not found"));
    }

    @DeleteMapping("/delete/{reviewID}")
    public ResponseEntity deleteReview(@PathVariable String reviewID) {
        boolean isDeleted = reviewService.deleteReview(reviewID);
        if (isDeleted) {
            return ResponseEntity.status(200).body(new APIResponse("Successfully deleted review"));
        }
        return ResponseEntity.status(400).body(new APIResponse("Review not found"));
    }

    @GetMapping("/getcomment/{productID}")
    public ResponseEntity getReviewComment(@PathVariable String productID) {
        return ResponseEntity.status(200).body(reviewService.getReviewComment(productID));
    }

    @GetMapping("/getRating/{rating}")
    public ResponseEntity getReviewRating(@PathVariable int rating) {
        return ResponseEntity.status(200).body(reviewService.getRating(rating));
    }
    @GetMapping("/find/{productID}/{comment}")
    public ResponseEntity findComment(@PathVariable String productID,@PathVariable String comment) {
        return ResponseEntity.status(200).body(reviewService.findComment(productID,comment));}



}







