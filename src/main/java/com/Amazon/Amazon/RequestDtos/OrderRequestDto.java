package com.Amazon.Amazon.RequestDtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequestDto {
    private int productId;
    private int customerId;
    private int requiredQuantity;

}
