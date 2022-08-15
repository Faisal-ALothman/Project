package com.example.amazon;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping
public class MerchantStockController {
    private final MerchantStockService merchantStockService;

    public MerchantStockController(MerchantStockService merchantStockService) {
        this.merchantStockService = merchantStockService;
    }

    @GetMapping("/merchantStock")
    public ResponseEntity getMerchantStock() {
        ArrayList<MerchantStock> merchantStock = merchantStockService.getMerchantStock();
        return ResponseEntity.status(200).body(merchantStock);
    }

    @PostMapping("/register")
    public ResponseEntity addMerchantStock(@RequestBody @Valid MerchantStock merchantStock, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message, 400));
        }
        this.merchantStockService.addMerchantStock(merchantStock);
        return ResponseEntity.status(201).body(new ApiResponse("New MerchantStock added !", 201));

    }
    @PutMapping("/merchantStock/{index}")
    public ResponseEntity updateMerchantStock(@RequestBody @Valid MerchantStock merchantStock, @PathVariable int index, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
        this.merchantStockService.updateMerchantStock(index,merchantStock);
        return ResponseEntity.status(201).body( new ApiResponse("MerchantStock updated !",201));
    }
    @DeleteMapping("/merchantStock/{index}")
    public ResponseEntity deleteMerchantStock(@PathVariable int index){
        this.merchantStockService.deleteMerchantStock(index);
        return ResponseEntity.status(200).body(new ApiResponse("merchantStock deleted !",200));
    }}