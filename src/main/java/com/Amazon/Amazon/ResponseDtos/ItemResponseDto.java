package com.Amazon.Amazon.ResponseDtos;


import com.Amazon.Amazon.Enum.Catagory;
import com.Amazon.Amazon.Enum.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemResponseDto {

    private int productId;
    private int price;
    private Catagory productCatagory;
    private ProductStatus productStatus;
}
