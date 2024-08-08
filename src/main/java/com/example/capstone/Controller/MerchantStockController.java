package com.example.capstone.Controller;

import com.example.capstone.API.APIResponse;
import com.example.capstone.Model.MerchantStock;
import com.example.capstone.Service.MerchantStockService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/merchantStock")
@RequiredArgsConstructor
public class MerchantStockController {
    private final MerchantStockService merchantStockService;
    @GetMapping("/get")
    public ResponseEntity GetMerchantStock() {
        return ResponseEntity.status(200).body(merchantStockService.getMerchantStocks());
    }
    @PostMapping("/add")
    public ResponseEntity AddMerchantStock(@Valid @RequestBody MerchantStock merchantStock, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);}
            merchantStockService.addMerchantStock(merchantStock);
            return ResponseEntity.status(200).body(new APIResponse("Successfully added merchant stock"));}

    @PutMapping("/update/{merchantStockID}")
    public ResponseEntity updateMerchantStock(@PathVariable String merchantStockID ,@Valid @RequestBody MerchantStock merchantStock, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);}
            boolean isUpdated = merchantStockService.updateMerchantStock(merchantStockID,merchantStock);
            if (isUpdated) {
            return ResponseEntity.status(200).body(new APIResponse("Successfully updated merchant stock"));}
            return ResponseEntity.status(400).body(new APIResponse("Not found merchant stock"));}

    @DeleteMapping("/delete/{merchantStockID}")
    public ResponseEntity deleteMerchantStock(@PathVariable String merchantStockID) {
            boolean isDeleted= merchantStockService.deleteMerchantStock(merchantStockID);
            if (isDeleted) {
            return ResponseEntity.status(200).body(new APIResponse("Successfully deleted merchant stock"));}
            return ResponseEntity.status(400).body(new APIResponse("Not found merchant stock"));}


    @PutMapping("/change/{ProductID}/{MerchantID}/{MerchantStockID}/{stock}")
    public ResponseEntity changeMerchantStock(@PathVariable String ProductID, @PathVariable String MerchantID,@PathVariable String MerchantStockID, @PathVariable int stock) {
        boolean isChanged = merchantStockService.changeMerchantStock(ProductID,MerchantID,MerchantStockID,stock);
        if (isChanged) {
            return ResponseEntity.status(200).body(new APIResponse("Successfully changed stock"));
        }
        return ResponseEntity.status(400).body(new APIResponse("Not found merchant stock"));
    }


//    @PutMapping("/set/{UserID}/{ProductID}/{MerchantID}/{MerchantStockID}")
//    public ResponseEntity buyProduct(@PathVariable String UserID,@PathVariable String ProductID,@PathVariable String MerchantID) {
//        int isSet = merchantStockService.buyProduct(UserID,ProductID,MerchantID);
//        if (isSet==1) {
//            return ResponseEntity.status(400).body(new APIResponse("Out of stock"));
//        }if(isSet==3){
//            return ResponseEntity.status(400).body(new APIResponse("Balance is less than the product price"));
//        }   if(isSet == 4){
//            return ResponseEntity.status(400).body(new APIResponse("Not found"));}
//
//        return ResponseEntity.status(200).body(new APIResponse("Successfully set"));
//    }


    @PutMapping("/discount/{UserAdminID}/{ProductID}")
    public ResponseEntity discount(@PathVariable String UserAdminID,@PathVariable String ProductID) {
    boolean isDiscount = merchantStockService.discount(UserAdminID,ProductID);
    if (isDiscount) {
        return ResponseEntity.status(200).body(new APIResponse("Successfully discount"));
    }
    return ResponseEntity.status(400).body(new APIResponse("Not found"));
    }


//    @PutMapping("/set/{orderID}/{userID}/{productID}/{merchantID}")
//    public ResponseEntity changeStatus(@PathVariable String orderID,@PathVariable String userID, @PathVariable String productID, @PathVariable String merchantID) {
//        boolean isUpdated = merchantStockService.changeStatus(orderID,userID,productID,merchantID);
//        if (isUpdated) {
//            return ResponseEntity.status(200).body(new APIResponse("Successfully updated"));
//        }
//        return ResponseEntity.status(400).body(new APIResponse("Not found"));
//    }









}
