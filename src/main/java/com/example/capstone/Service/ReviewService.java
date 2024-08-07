package com.example.capstone.Service;

import com.example.capstone.Model.Product;
import com.example.capstone.Model.Review;
import com.example.capstone.Model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class ReviewService {
    private final ProductService productService;
    private final UserService userService;

    ArrayList<Review> reviews = new ArrayList<>();

    public ArrayList<Review> getReviews() {
        return reviews;
    }

    public void addReview(Review review) {
        reviews.add(review);
    }

    public boolean updateReview(String reviewID, Review review) {
        for (int i = 0; i < reviews.size(); i++) {
            if (reviews.get(i).getId().equals(reviewID)) {
                reviews.set(i, review);
                return true;
            }
        }
        return false;
    }

    public boolean deleteReview(String reviewID) {
        for (int i = 0; i < reviews.size(); i++) {
            if (reviews.get(i).getId().equals(reviewID)) {
                reviews.remove(i);
                return true;
            }
        }
        return false;
    }


    public ArrayList<Review> getReviewComment(String productID) {
        ArrayList<Review> reviews1 = new ArrayList<>();
        for (int i = 0; i < reviews.size(); i++) {
            if (reviews.get(i).getProductId().equals(productID)) {
                reviews1.add(reviews.get(i));
            }
        }
        return reviews1;
    }

    public ArrayList<Review> getRating(int rating) {
        ArrayList<Review> reviews1 = new ArrayList<>();
        for (int i = 0; i < reviews.size(); i++) {
            if (reviews.get(i).getRating() >= rating) {
                reviews1.add(reviews.get(i));
            }
        }
        return reviews1;
    }

    public ArrayList<Review> findComment( String productID, String comment) {
        ArrayList<Review> reviews1 = new ArrayList<>();
        for(Product p: productService.getProducts()) {
            if(p.getId().equals(productID)) {
                        for(int i=0 ;i<reviews.size(); i++){
                            if(reviews.get(i).getComment().equalsIgnoreCase(comment)) {
                                reviews1.remove(reviews.get(i));}}}
                        }return reviews1;
                    }





}





















