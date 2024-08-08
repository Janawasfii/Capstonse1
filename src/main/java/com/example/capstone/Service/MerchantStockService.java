package com.example.capstone.Service;

import com.example.capstone.Model.Merchant;
import com.example.capstone.Model.MerchantStock;
import com.example.capstone.Model.Product;
import com.example.capstone.Model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class MerchantStockService {
    private final MerchantService merchantService;
    private final ProductService productService;
    private final UserService userService;

    ArrayList<MerchantStock> merchantStocks = new ArrayList<MerchantStock>();

    public ArrayList<MerchantStock> getMerchantStocks() {
        return merchantStocks;}

    public void addMerchantStock(MerchantStock merchantStock){
        merchantStocks.add(merchantStock);}

    public boolean updateMerchantStock(String mechantStockID ,MerchantStock merchantStock){
        for(int i = 0; i < merchantStocks.size(); i++){
            if(merchantStocks.get(i).getId().equals(mechantStockID)){
                merchantStocks.set(i,merchantStock);
                return true;}}
                return false;}

    public boolean deleteMerchantStock(String mechantStockID){
        for(int i = 0; i < merchantStocks.size(); i++){
            if(merchantStocks.get(i).getId().equals(mechantStockID)){
                merchantStocks.remove(i);
                return true;}}
                return false;}

    public boolean changeMerchantStock(String ProductID,String MerchantID,String MerchantStockID,int stock){
        for(int i = 0; i < merchantStocks.size(); i++){
            if(merchantStocks.get(i).getProductID().equals(ProductID)) {
            for(int j = 0; j < merchantStocks.size(); j++){
                 if(merchantStocks.get(j).getMerchantID().equals(MerchantID)) {
                 for (int k = 0; k < merchantStocks.size(); k++) {
                     if(merchantStocks.get(i).getId().equals(MerchantStockID)){
                      if(merchantStocks.get(k).getStock() > 0){
                          merchantStocks.get(k).setStock(merchantStocks.get(k).getStock()+stock);
                    return true;
                }}}}} }}return false;}



    public boolean discount(String UserAdminID,  String ProductID){
        for (int i = 0; i < userService.users.size(); i++) {
            if(userService.users.get(i).getId().equals(UserAdminID) && userService.users.get(i).getRole().equalsIgnoreCase("Admin")){
                if (merchantStocks.get(i).getProductID().equals(ProductID)) {
                    if (merchantStocks.get(i).getStock() > 0) {
                        productService.products.get(i).setProductPrice(productService.products.get(i).getProductPrice() * 0.20);
                        return true;
                    } }}
        }return false;}













}







