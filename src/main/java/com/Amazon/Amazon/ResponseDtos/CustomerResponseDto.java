package com.Amazon.Amazon.ResponseDtos;


import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponseDto {
    private String customerName;
    private int customerAge;
    private String customerEmail;

    private String mobileNumber;
}
