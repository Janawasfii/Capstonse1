package com.example.capstone.Service;

import com.example.capstone.Model.Merchant;
import com.example.capstone.Model.Order;
import com.example.capstone.Model.Product;
import com.example.capstone.Model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final MerchantService merchantService;

    ArrayList<Order> orders = new ArrayList<Order>();

    public ArrayList<Order> getOrder() {
        return orders;
    }
    public void addOrder(Order order) {
        orders.add(order);
    }
    public boolean updateOrder(String orderID,Order order) {
        for (int i = 0; i < orders.size(); i++) {
            if(order.getId().equals(orderID)){
                orders.set(i, order);
                return true;}}
        return false;}

    public boolean deleteOrder(String orderID) {
        for (int i = 0; i < orders.size(); i++) {
            if(orders.get(i).getId().equals(orderID)){
                orders.remove(i);
                return true;
            }
        }
        return false;
    }
     public boolean changeStatus(String OrderID,String userID,String ProductID,String MerchantID){
        for (int i = 0; i < orders.size(); i++) {
        if(orders.get(i).getId().equals(OrderID)){
        for(int j=0;j<orders.size();j++){
        if(orders.get(j).getUserID().equals(userID)){
        for(int k=0;k<orders.size();k++){
        if(orders.get(k).getProductID().equals(ProductID)){
        for(int l=0;l<orders.size();l++){
        if(merchantService.merchants.get(l).getId().equals(MerchantID)){
        if(orders.get(k).getStatus().equals("PLACED")){
        orders.get(j).setStatus("PROCESSING");}
        else if(orders.get(k).getStatus().equals("PROCESSING")){
        orders.get(j).setStatus("SHIPPED");}
        else if(orders.get(k).getStatus().equals("SHIPPED")){
        orders.get(j).setStatus("DELIVERED");}
        return true;}}}}}}}}
         return false;}














}





