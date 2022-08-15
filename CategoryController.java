package com.example.amazon;

import com.example.amazon.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/AmazonClone")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/category")
    public ResponseEntity getCategory(){
        ArrayList<Category> category=categoryService.getCategory();
        return ResponseEntity.status(200).body(category);
    }
    @PostMapping("/register")
    public ResponseEntity addCategory(@RequestBody @Valid Category category, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
        this.categoryService.addCategory(category);
        return ResponseEntity.status(201).body( new ApiResponse("New user added !",201));
    }
    //
    @PutMapping("/category/{index}")
    public ResponseEntity updateCategory(@RequestBody @Valid Category category, @PathVariable int index, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
        this.categoryService.updateCategory(index,category);
        return ResponseEntity.status(201).body( new ApiResponse("Category updated !",201));
    }

    @DeleteMapping("/category/{index}")
    public ResponseEntity deleteCategory(@PathVariable int index){
        this.categoryService.deleteCategory(index);
        return ResponseEntity.status(200).body(new ApiResponse("Category deleted !",200));
    }
}
