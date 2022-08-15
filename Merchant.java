package com.example.amazon;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@AllArgsConstructor
@Data
public class Merchant {
    @NotNull(message = "id cant be null")
    @Size(min = 3 , message = "id length must be more than 2")
    private String MerchantID;

    @NotNull (message = "name cant be null")
    @Size(min = 4 , message = "name length must be more than 3")
    private String MerchantName;
}
