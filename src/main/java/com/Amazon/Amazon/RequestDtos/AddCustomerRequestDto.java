package com.Amazon.Amazon.RequestDtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddCustomerRequestDto {
    private String name;
    private String email;
    private String mobile;
    private int age;
}
