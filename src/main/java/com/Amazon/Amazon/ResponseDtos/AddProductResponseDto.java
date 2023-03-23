package com.Amazon.Amazon.ResponseDtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddProductResponseDto {
    private String productName;
    private int productPrice;
    private int productQuantity;
}
