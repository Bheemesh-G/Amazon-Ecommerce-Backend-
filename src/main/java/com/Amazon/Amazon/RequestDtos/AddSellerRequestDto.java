package com.Amazon.Amazon.RequestDtos;


import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddSellerRequestDto {
    private String sellerName;

    private String sellerEmail;


    private String sellerMobile;


    private String sellerPanNumber;

}
