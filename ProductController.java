package com.example.amazon;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
@RestController
@RequestMapping("/api/v1/AmazonClone")
public class ProductController {
    private final ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/product")
    public ResponseEntity getProduct(){
        ArrayList<Product> users=productService.getProducts();
        return ResponseEntity.status(200).body(users);
    }
    @PostMapping("/register")
    public ResponseEntity addProduct(@RequestBody @Valid Product myProduct, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
        productService.addProduct(myProduct);
        return ResponseEntity.status(201).body( new ApiResponse("New user added !",201));
    }
    @PutMapping("/product/{index}")
    public ResponseEntity updateProduct(@RequestBody @Valid Product myProduct
            , @PathVariable int index, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
        productService.updateProduct(index,myProduct);
        return ResponseEntity.status(201).body( new ApiResponse("Product updated !",201));
    }
    @DeleteMapping("/product/{index}")
    public ResponseEntity deleteProduct(@PathVariable int index){
        productService.deleteProduct(index);
        return ResponseEntity.status(200).body(new ApiResponse("Product deleted !",200));
    }
}
