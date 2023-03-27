package com.Amazon.Amazon.Controller;


import com.Amazon.Amazon.RequestDtos.AddCustomerRequestDto;
import com.Amazon.Amazon.ResponseDtos.CustomerResponseDto;
import com.Amazon.Amazon.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;


    @PostMapping("/add-customer")
    public String addCustomer(@RequestBody AddCustomerRequestDto addCustomerRequestDto)
    {
        return customerService.addCustomer(addCustomerRequestDto);
    }


    @GetMapping("/get-customer-by-id/{id}")
    public ResponseEntity getCustomer(@PathVariable int id)
    {
        CustomerResponseDto customerResponseDto;
        try{
            customerResponseDto = customerService.getCustomer(id);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(customerResponseDto,HttpStatus.ACCEPTED);
    }


    @GetMapping("/get-all-customers")
    public List<CustomerResponseDto> getAllCustomers()
    {
        return customerService.getAllCustomers();
    }


    @DeleteMapping("/delete-customer-by-id/{id}")
    public String deleteCustomer(@PathVariable int id)
    {
        return customerService.deleteCustomer(id);
    }


    @GetMapping("/get-customer-by-email/{email}")
    public CustomerResponseDto getByEmail(@PathVariable String email)
    {
        return customerService.getByEmail(email);
    }


    @PutMapping("/update-customer-by-id/{id}")
    public ResponseEntity updateCustomer(@PathVariable int id,@RequestBody AddCustomerRequestDto addCustomerRequestDto) throws Exception{
        String ans;
        try{
            ans = customerService.updateCustomer(id,addCustomerRequestDto);
        }
        catch(Exception e)
        {
            return  new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(ans,HttpStatus.ACCEPTED);
    }
}
