package com.example.capstone.Controller;

import com.example.capstone.API.APIResponse;
import com.example.capstone.Model.Order;
import com.example.capstone.Service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    @GetMapping("/get")
    public ResponseEntity getOrder(){
        return  ResponseEntity.status(200).body(orderService.getOrder());
    }
    @PostMapping("/add")
    public ResponseEntity addOrder(@Valid @RequestBody Order order, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        orderService.addOrder(order);
        return ResponseEntity.status(200).body("Successfully added order");
    }
    @PutMapping("/update/{orderID}")
    public ResponseEntity updateOrder(@PathVariable String orderID,@Valid @RequestBody Order order, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated = orderService.updateOrder(orderID,order);
        if(isUpdated){
            return ResponseEntity.status(200).body("Successfully updated order");
        }
        return ResponseEntity.status(400).body("Order not found");
    }
    @DeleteMapping("/delete/{orderID}")
    public ResponseEntity deleteOrder(@PathVariable String orderID){
        boolean isDeleted = orderService.deleteOrder(orderID);
        if(isDeleted){
            return ResponseEntity.status(200).body("Successfully deleted order");
        }
        return ResponseEntity.status(400).body("Order not found");
    }

    @PutMapping("/set/{orderID}/{userID}/{productID}/{merchanID}")
    public ResponseEntity changeStatus(@PathVariable String orderID,@PathVariable String userID, @PathVariable String productID, @PathVariable String merchanID) {
        boolean isUpdated = orderService.changeStatus(orderID,userID,productID,merchanID);
        if (isUpdated) {
            return ResponseEntity.status(200).body(new APIResponse("Successfully updated"));
        }
        return ResponseEntity.status(400).body(new APIResponse("Not found"));
    }


}
