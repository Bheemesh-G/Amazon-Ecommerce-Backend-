package com.Amazon.Amazon.RequestDtos;

import com.Amazon.Amazon.Enum.Catagory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddProductRequestDto {
    private int sellerId;
    private String name;
    private int price;
    private int quantity;
    private Catagory catagory;

}
