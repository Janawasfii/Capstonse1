package com.example.capstone.Service;

import com.example.capstone.Model.Merchant;

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
        for (int i = 0; i < merchants.size(); i++) {
            if(merchants.get(i).getId().equals(OrderID)){
                for(int j=0;j<merchants.size();j++){
                    if(userService.users.get(i).getId().equals(userID)){
                        for(int k=0;k<merchants.size();k++){
                            if(productService.products.get(k).getId().equals(ProductID)){
                                for(int l=0;l<merchants.size();l++){
                                    if(merchants.get(l).getId().equals(MerchantID)){
                                        if(merchants.get(k).getStatus().equals("PLACED")){
                                            merchants.get(j).setStatus("PROCESSING");}
                                        else if(merchants.get(k).getStatus().equals("PROCESSING")){
                                            merchants.get(j).setStatus("SHIPPED");}
                                        else if(merchants.get(k).getStatus().equals("SHIPPED")){
                                            merchants.get(j).setStatus("DELIVERED");}
                                        return true;}}}}}}}}
        return false;}













}









