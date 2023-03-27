package com.Amazon.Amazon.Service;


import com.Amazon.Amazon.Converter.CustomerConverter;
import com.Amazon.Amazon.Entity.Cart;
import com.Amazon.Amazon.Entity.Customer;
import com.Amazon.Amazon.Repository.CustomerRepository;
import com.Amazon.Amazon.RequestDtos.AddCardRequestDto;
import com.Amazon.Amazon.RequestDtos.AddCustomerRequestDto;
import com.Amazon.Amazon.ResponseDtos.CustomerResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.tree.ExpandVetoException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public String addCustomer(AddCustomerRequestDto addCustomerRequestDto)
    {
        Customer customer = CustomerConverter.convertCustomer(addCustomerRequestDto);

        Cart cart = new Cart();
        cart.setCardTotal(0);
        cart.setCustomer(customer);

        customer.setCart(cart);


        customerRepository.save(customer);

        return "Your account has been Created Successfully.....";
    }

    public CustomerResponseDto getCustomer(int id) throws Exception {
        Customer customer;
        try{
            customer = customerRepository.findById(id).get();
        }
        catch(Exception e)
        {
            throw new Exception("Invalid Customer Id");
        }

        CustomerResponseDto customerResponseDto = new CustomerResponseDto();
        customerResponseDto.setCustomerName(customer.getCustomerName());
        customerResponseDto.setMobileNumber(customer.getMobileNumber());
        customerResponseDto.setCustomerAge(customer.getCustomerAge());
        customerResponseDto.setCustomerEmail(customer.getCustomerEmail());


        return customerResponseDto;
    }

    public List<CustomerResponseDto> getAllCustomers()
    {
        List<Customer> customerList = customerRepository.findAll();
        List<CustomerResponseDto> list = new ArrayList<>();

        for(Customer i:customerList)
        {
            CustomerResponseDto customerResponseDto = new CustomerResponseDto();
            customerResponseDto.setCustomerName(i.getCustomerName());
            customerResponseDto.setCustomerAge(i.getCustomerAge());
            customerResponseDto.setCustomerEmail(i.getCustomerEmail());
            customerResponseDto.setMobileNumber(i.getMobileNumber());
            list.add(customerResponseDto);
        }


        return list;

    }

    public String deleteCustomer(int id)
    {
        customerRepository.deleteById(id);

        return "Customer deleted Successfully...";
    }

    public CustomerResponseDto getByEmail(String email)
    {
        Customer customer = customerRepository.findByCustomerEmail(email);
        CustomerResponseDto customerResponseDto = new CustomerResponseDto();
        customerResponseDto.setCustomerName(customer.getCustomerName());
        customerResponseDto.setCustomerEmail(customer.getCustomerEmail());
        customerResponseDto.setCustomerAge(customer.getCustomerAge());
        customerResponseDto.setMobileNumber(customer.getMobileNumber());

        return customerResponseDto;
    }

    public String updateCustomer(int id,AddCustomerRequestDto addCustomerRequestDto) throws Exception {

        Customer customer;
        try{
            customer = customerRepository.findById(id).get();
        }
        catch(Exception e)
        {
            throw new Exception("Invalid User Id");
        }

        customer.setCustomerName(addCustomerRequestDto.getName());
        customer.setCustomerAge(addCustomerRequestDto.getAge());
        customer.setCustomerEmail(addCustomerRequestDto.getEmail());
        customer.setMobileNumber(addCustomerRequestDto.getMobile());

        customerRepository.save(customer);

        return "Customer Updated Successfully";


    }
}
