package com.example.amazon;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@AllArgsConstructor
@Data
public class MerchantStock {
    @NotNull(message = "id cant be null")
    @Size(min = 3 , message = "id length must be more than 2")
    private String MerchantStockId;

    @NotNull (message = "id cant be null")
    @Size(min = 3 , message = "id length must be more than 2")
    private String productid;

    @NotNull(message = "id cant be null")
    @Size(min = 3 , message = "id length must be more than 2")
    private String merchantid;


    @NotNull (message = "id cant be null")
    @Size(min = 10 , message = "stock length must be more than 10")
    private int stock;
}