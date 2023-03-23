package com.Amazon.Amazon.Converter;


import com.Amazon.Amazon.Entity.Product;
import com.Amazon.Amazon.Entity.Seller;
import com.Amazon.Amazon.Enum.Catagory;
import com.Amazon.Amazon.Enum.ProductStatus;
import com.Amazon.Amazon.RequestDtos.AddProductRequestDto;
import com.Amazon.Amazon.ResponseDtos.AddProductResponseDto;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class ProductConverter {
    public static Product productConverter(AddProductRequestDto addProductRequestDto)
    {
        Product product = new Product();
        product.setProductName(addProductRequestDto.getName());
        product.setProductPrice(addProductRequestDto.getPrice());
        product.setProductQuantity(addProductRequestDto.getQuantity());
        product.setProductStatus(ProductStatus.AVAILABLE);
        product.setCatagory(addProductRequestDto.getCatagory());

        return product;
    }

    public AddProductResponseDto getProduct1(Product product)
    {
        AddProductResponseDto addProductResponseDto = new AddProductResponseDto();
        addProductResponseDto.setProductName(product.getProductName());
        addProductResponseDto.setProductPrice(product.getProductPrice());
        addProductResponseDto.setProductQuantity(product.getProductQuantity());

        return addProductResponseDto;
    }

    public List<AddProductResponseDto> getAllProducts(List<Product> productList)
    {
        List<AddProductResponseDto> list = new ArrayList<>();
        for(Product i:productList)
        {
            AddProductResponseDto addProductResponseDto = new AddProductResponseDto();
            addProductResponseDto.setProductName(i.getProductName());
            addProductResponseDto.setProductPrice(i.getProductPrice());
            addProductResponseDto.setProductQuantity(i.getProductQuantity());
            list.add(addProductResponseDto);
        }

        return list;
    }

}
