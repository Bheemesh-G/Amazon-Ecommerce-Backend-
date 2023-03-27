package com.Amazon.Amazon.Controller;


import com.Amazon.Amazon.RequestDtos.OrderRequestDto;
import com.Amazon.Amazon.ResponseDtos.OrderedResponseDto;
import com.Amazon.Amazon.Service.OrderedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderedController {
    @Autowired
    OrderedService orderedService;


    @PostMapping("/placeorder")
    public ResponseEntity placeOrder(@RequestBody OrderRequestDto orderRequestDto)
    {
        OrderedResponseDto orderedResponseDto;
        try{
            orderedResponseDto = orderedService.placeOrder(orderRequestDto);
        }
        catch(Exception e)
        {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(orderedResponseDto,HttpStatus.ACCEPTED);
    }
}
