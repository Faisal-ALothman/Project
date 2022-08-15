package com.example.amazon;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@AllArgsConstructor @Data
public class Product {
    @NotNull(message = "id cant be null")
    @Size(min = 3 , message = "id length must be more than 2")
    private String ProductId;


    @NotNull (message = "id cant be null")
    @Size(min = 3 , message = "id length must be more than 2")
    private String ProductName;


    @NotNull (message = "input cant be null")
    @Pattern(regexp = "^\\d{0,8}(\\.\\d{1,4})?$",message="price must be a positive number")
    @Range(min = 1,max = 9 , message = "id length must be more than 25 and less than 9")
    private int ProductPrice;

    @NotNull (message = "id cant be null")
    @Size(min = 3 , message = "id length must be more than 2")
    private String categoryId;

}