package com.example.capstone.Service;

import com.example.capstone.Model.Merchant;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class MerchantService {
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
            return false;}}









