package com.example.capstone.Service;


import com.example.capstone.Model.*;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class UserService {
    private final ProductService productService;
    private final ReviewService reviewService;
    private final MerchantStockService merchantStockService;


    ArrayList<User> users = new ArrayList<User>();

    public ArrayList<User> getUsers() {
        return users;
    }

    public void addUsers(User user) {
        users.add(user);
    }

    public boolean updateUser(String userID, User user) {
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getId().equals(userID)){
                users.set(i, user);
                return true;}}
                return false;}

    public boolean deleteUser(String userID) {
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getId().equals(userID)){
                users.remove(i);
                return true;}}
            return false;}

    public int buyProduct(String UserID,String ProductID,String MerchantID){
        for(MerchantStock merchantStock : merchantStockService.getMerchantStocks()){
            if(merchantStock.getId().equals(ProductID) && merchantStock.getMerchantID().equals(MerchantID)){
                for(int i=0; i<users.size();i++)
                    if(users.get(i).getId().equals(UserID)){
                        if(merchantStock.getStock()>0){
                            merchantStock.setStock(merchantStock.getStock()-1);}
                        else{ return 1;}
                        for(Product p: productService.getProducts()){
                            if(users.get(i).getBalance() >= p.getProductPrice()){
                                users.get(i).setBalance(users.get(i).getBalance()-p.getProductPrice());}
                            else {return 3;}
                            ArrayList<MerchantStock> boughtProduct = new ArrayList<>();
                            boughtProduct.add(merchantStock);
                            return 2;
                        }
                    }}}return 4;}




    public boolean deleteBadComment(String userID, String productID, String comment){
        for (User user : users) {
            if(user.getId().equals(userID)&& user.getRole().equalsIgnoreCase("Admin")){
                for (Product product : productService.getProducts()) {
                    if(product.getId().equals(productID)){
                        for(int i=0; i<reviewService.reviews.size(); i++){
                            if(reviewService.reviews.get(i).getComment().contains(comment)){
                                reviewService.reviews.remove(reviewService.reviews.get(i));
                                return true;}}}}}}
        return false;}

























}





