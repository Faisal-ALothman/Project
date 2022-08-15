package com.example.amazon;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/AmazonClone")
public class MerchantController {

    private final MerchantService merchantService;

    public MerchantController(MerchantService merchantService) {
        this.merchantService = merchantService;
    }

    @GetMapping("/merchant")
    public ResponseEntity getMerchant() {
        ArrayList<Merchant> merchant = merchantService.getMerchant();
        return ResponseEntity.status(200).body(merchant);
    }

    @PostMapping("/register")
    public ResponseEntity addMerchant(@RequestBody @Valid Merchant merchant, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message, 400));
        }
        this.merchantService.addMerchant(merchant);
        return ResponseEntity.status(201).body(new ApiResponse("New Merchant added !", 201));

    }
    @PutMapping("/merchant/{index}")
    public ResponseEntity updateMerchant(@RequestBody @Valid Merchant merchant, @PathVariable int index, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
        this.merchantService.updateMerchant(index,merchant);
        return ResponseEntity.status(201).body( new ApiResponse("Merchant updated !",201));
    }
    @DeleteMapping("/merchant/{index}")
    public ResponseEntity deleteMerchant(@PathVariable int index){
        this.merchantService.deleteMerchant(index);
        return ResponseEntity.status(200).body(new ApiResponse("merchant deleted !",200));
    }
}

