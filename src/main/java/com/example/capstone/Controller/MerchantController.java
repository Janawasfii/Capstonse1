package com.example.capstone.Controller;

import com.example.capstone.API.APIResponse;
import com.example.capstone.Model.Merchant;
import com.example.capstone.Service.MerchantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/v1/merchant")
@RequiredArgsConstructor
public class MerchantController {
    private final MerchantService merchantService;
    @GetMapping("/get")
    public ResponseEntity getMerchant() {
            return ResponseEntity.status(200).body(merchantService.getMerchants());}

    @PostMapping("/add")
    public ResponseEntity addMerchant(@Valid @RequestBody Merchant merchant, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);}
            merchantService.addMerchants(merchant);
            return ResponseEntity.status(200).body(new APIResponse("Successfully added"));}

    @PutMapping("/update/{merchantID}")
    public ResponseEntity updateMerchant(@PathVariable String merchantID,@Valid @RequestBody Merchant merchant, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated = merchantService.updateMerchant(merchantID,merchant);
        if (isUpdated) {
            return ResponseEntity.status(200).body(new APIResponse("Successfully updated"));
        }
        return ResponseEntity.status(400).body(new APIResponse("Not found"));

    }

    @DeleteMapping("/delete/{merchantID}")
    public ResponseEntity deleteMerchant(@PathVariable String merchantID) {
           boolean isDeleted = merchantService.deleteMerchant(merchantID);
           if (isDeleted) {
           return ResponseEntity.status(200).body(new APIResponse("Successfully deleted"));}
           return ResponseEntity.status(400).body(new APIResponse("Merchant not found"));}


    @PutMapping("/set/{orderID}/{userID}/{productID}/{merchantID}")
    public ResponseEntity changeStatus(@PathVariable String orderID,@PathVariable String userID, @PathVariable String productID, @PathVariable String merchantID) {
        boolean isUpdated = merchantService.changeStatus(orderID,userID,productID,merchantID);
        if (isUpdated) {
            return ResponseEntity.status(200).body(new APIResponse("Successfully updated"));
        }
        return ResponseEntity.status(400).body(new APIResponse("Not found"));
    }

}
