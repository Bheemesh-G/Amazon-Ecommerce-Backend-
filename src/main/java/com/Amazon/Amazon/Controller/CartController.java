package com.Amazon.Amazon.Controller;


import com.Amazon.Amazon.RequestDtos.OrderRequestDto;
import com.Amazon.Amazon.ResponseDtos.OrderedResponseDto;
import com.Amazon.Amazon.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {


    @Autowired
    CartService cartService;


    @PostMapping("/add")
    public ResponseEntity addToCart(@RequestBody OrderRequestDto orderRequestDto) throws Exception{

        String ans ="";
        try{
            ans = cartService.addToCart(orderRequestDto);
        }
        catch(Exception e)
        {
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }


        return new ResponseEntity(ans,HttpStatus.ACCEPTED);

    }

    @PostMapping("/checkout/{customerId}")
    public ResponseEntity checkoutCart(@PathVariable("customerId") int customerId){
        List<OrderedResponseDto> orderResponseDtos;
        try{
            orderResponseDtos = cartService.checkout(customerId);
        }
        catch(Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(orderResponseDtos,HttpStatus.ACCEPTED);
    }


}
