package com.Amazon.Amazon.Service;


import com.Amazon.Amazon.Converter.ProductConverter;
import com.Amazon.Amazon.Entity.Product;
import com.Amazon.Amazon.Entity.Seller;
import com.Amazon.Amazon.Enum.Catagory;
import com.Amazon.Amazon.Repository.ProductRepository;
import com.Amazon.Amazon.Repository.SellerRepository;
import com.Amazon.Amazon.RequestDtos.AddProductRequestDto;
import com.Amazon.Amazon.RequestDtos.AddSellerRequestDto;
import com.Amazon.Amazon.ResponseDtos.AddProductResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    SellerRepository sellerRepository;
    public AddProductResponseDto addProduct(AddProductRequestDto addProductRequestDto) throws Exception {
        Seller seller;
        try{
            seller = sellerRepository.findById(addProductRequestDto.getSellerId()).get();
        }
        catch(Exception e)
        {
            throw new Exception("Invalid SellerId");
        }
        Product product = ProductConverter.productConverter(addProductRequestDto);

        product.setSeller(seller);
        seller.getProductList().add(product);

       sellerRepository.save(seller);

       AddProductResponseDto response = ProductConverter.getProduct1(product);

       return response;


    }

    public List<AddProductResponseDto> getAllProductsByCatagory(Catagory catagory)
    {
        List<Product> productList = productRepository.findByCatagory(catagory);
        List<AddProductResponseDto> list = ProductConverter.getAllProducts(productList);
        return list;
    }
}
