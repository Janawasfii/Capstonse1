package com.example.capstone.Service;

import com.example.capstone.Model.Merchant;

import com.example.capstone.Model.Product;
import com.example.capstone.Model.User;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class MerchantService {
    private final ProductService productService;
    private final UserService userService;
    ArrayList<Merchant> merchants = new ArrayList<Merchant>();

//      private final UserService userService;
//
//      private final ProductService productService;
 //  private final OrderService orderService;


    public  ArrayList<Merchant> getMerchants() {
        return merchants;}

    public void addMerchants(Merchant merchant) {
        merchants.add(merchant);}

    public boolean updateMerchant(String merchantID,Merchant merchant) {
        for (int i = 0; i < merchants.size(); i++) {
            if(merchants.get(i).getId().equals(merchantID)){
            merchants.set(i,merchant);
            return true;}}
            return false;}

    public boolean deleteMerchant(String merchantID) {
        for (int i = 0; i < merchants.size(); i++) {
            if(merchants.get(i).getId().equals(merchantID));
            merchants.remove(i);
            return true;}
            return false;}



    public boolean changeStatus(String OrderID,String userID,String ProductID,String MerchantID){
        for (Merchant merchant : merchants) {
            if(merchant.getId().equals(OrderID) && merchant.getId().equals(MerchantID)){
                for( User u: userService.getUsers()) {
                    if(u.getId().equals(userID)) {
                        for( Product p: productService.getProducts()) {
                            if(p.getId().equals(ProductID)) {
                                        if(merchant.getStatus().equals("PLACED")){
                                            merchant.setStatus("PROCESSING");}
                                        else if(merchant.getStatus().equals("PROCESSING")){
                                            merchant.setStatus("SHIPPED");}
                                        else if(merchant.getStatus().equals("SHIPPED")){
                                            merchant.setStatus("DELIVERED");}
                                        return true;}}}}}}
        return false;
    }
        }























