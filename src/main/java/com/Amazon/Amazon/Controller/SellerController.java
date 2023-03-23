package com.Amazon.Amazon.Controller;


import com.Amazon.Amazon.Entity.Seller;
import com.Amazon.Amazon.RequestDtos.AddSellerRequestDto;
import com.Amazon.Amazon.ResponseDtos.AddProductResponseDto;
import com.Amazon.Amazon.ResponseDtos.AllSellersResponseDto;
import com.Amazon.Amazon.Service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seller")
public class SellerController {

    @Autowired
    SellerService sellerService;

    @PostMapping("/add-seller")
    public String addSeller(@RequestBody AddSellerRequestDto addSellerRequestDto)
    {
        return sellerService.addSeller(addSellerRequestDto);
    }

    @GetMapping("get-all-sellers")
    public List<AllSellersResponseDto> getAllSellers()
    {
       return sellerService.getAllSellers();
    }
    @GetMapping("/get-by-id/{id}")
    public String getById(@PathVariable int id)
    {
        return sellerService.getById(id);
    }

    @GetMapping("/get-by-pannumber")
    public ResponseEntity findByPanNumber (@RequestParam String panNumber)
    {
        Seller seller =sellerService.findByPanNumber(panNumber);

        return new ResponseEntity(seller.getSellerName(),HttpStatus.ACCEPTED);
    }


    @GetMapping("/list-of-products-by-sellerid/{sellerId}")
    public List<AddProductResponseDto> getAllProductsBySellerId(@PathVariable int sellerId)
    {
       return sellerService.getAllProductsBySellerId(sellerId);
    }
}
