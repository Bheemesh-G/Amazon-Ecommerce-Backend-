package com.Amazon.Amazon.Service;


import com.Amazon.Amazon.Converter.ProductConverter;
import com.Amazon.Amazon.Converter.SellerConverter;
import com.Amazon.Amazon.Entity.Product;
import com.Amazon.Amazon.Entity.Seller;
import com.Amazon.Amazon.Repository.SellerRepository;
import com.Amazon.Amazon.RequestDtos.AddSellerRequestDto;
import com.Amazon.Amazon.ResponseDtos.AddProductResponseDto;
import com.Amazon.Amazon.ResponseDtos.AllSellersResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerService {

    @Autowired
    SellerRepository sellerRepository;

    public String addSeller(AddSellerRequestDto addSellerRequestDto)
    {
        Seller seller = SellerConverter.addSellerConverter(addSellerRequestDto);

        sellerRepository.save(seller);
        return "Congratulations! now you can sell on Amazon";
    }

    public List<AllSellersResponseDto> getAllSellers()
    {
        List<Seller> list = sellerRepository.findAll();
        List<AllSellersResponseDto> list1 = SellerConverter.allSellerConverter(list);
        return list1;
    }

    public String getById(int id)
    {
        return sellerRepository.findById(id).get().getSellerName();
    }

    public Seller findByPanNumber(String panNumber) {

         Seller seller =  sellerRepository.findBySellerPanNumber(panNumber);


        return seller;
    }

    public List<AddProductResponseDto> getAllProductsBySellerId(int sellerId)
    {
       List<Product> productList = sellerRepository.findById(sellerId).get().getProductList();

       List<AddProductResponseDto> list = ProductConverter.getAllProducts(productList);

       return list;

    }
}
