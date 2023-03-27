package com.Amazon.Amazon.Converter;


import com.Amazon.Amazon.Entity.Customer;
import com.Amazon.Amazon.RequestDtos.AddCustomerRequestDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CustomerConverter {
    public static Customer convertCustomer(AddCustomerRequestDto addCustomerRequestDto)
    {
        Customer customer = new Customer();
        customer.setCustomerName(addCustomerRequestDto.getName());
        customer.setCustomerEmail(addCustomerRequestDto.getEmail());
        customer.setMobileNumber(addCustomerRequestDto.getMobile());
        customer.setCustomerAge(addCustomerRequestDto.getAge());

        return customer;
    }
}
