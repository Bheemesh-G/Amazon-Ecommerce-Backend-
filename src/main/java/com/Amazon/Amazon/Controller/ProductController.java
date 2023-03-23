package com.Amazon.Amazon.Controller;


import com.Amazon.Amazon.Enum.Catagory;
import com.Amazon.Amazon.RequestDtos.AddProductRequestDto;
import com.Amazon.Amazon.ResponseDtos.AddProductResponseDto;
import com.Amazon.Amazon.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("/add-product")
    public ResponseEntity addProduct(@RequestBody AddProductRequestDto addProductRequestDto)
    {
        AddProductResponseDto addProductResponseDto;
        try{
            addProductResponseDto = productService.addProduct(addProductRequestDto);
        }
        catch(Exception e)
        {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(addProductResponseDto,HttpStatus.ACCEPTED);
    }


    @GetMapping("/get-all-products/{catagory}")
    public List<AddProductResponseDto> getAllProductsByCatagory(@PathVariable Catagory catagory)
    {
        return productService.getAllProductsByCatagory(catagory);
    }
}
