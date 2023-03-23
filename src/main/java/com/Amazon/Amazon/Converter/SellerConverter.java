package com.Amazon.Amazon.Converter;

import com.Amazon.Amazon.Entity.Seller;
import com.Amazon.Amazon.RequestDtos.AddSellerRequestDto;
import com.Amazon.Amazon.ResponseDtos.AllSellersResponseDto;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;


@UtilityClass
public class SellerConverter {

    public static  Seller addSellerConverter(AddSellerRequestDto addSellerRequestDto)
    {
        return Seller.builder()
                .sellerName(addSellerRequestDto.getSellerName())
                .sellerEmail(addSellerRequestDto.getSellerEmail())
                .sellerMobile(addSellerRequestDto.getSellerMobile())
                .sellerPanNumber(addSellerRequestDto.getSellerPanNumber())
                .build();
    }

    public static List<AllSellersResponseDto> allSellerConverter(List<Seller> list)
    {
        List<Seller> sellerList = list;
        List<AllSellersResponseDto> list1 = new ArrayList<>();
        for(Seller i:sellerList)
        {
            AllSellersResponseDto allSellersResponseDto = new AllSellersResponseDto();
          //  allSellersResponseDto.setId(i.getSellerId());
            allSellersResponseDto.setName(i.getSellerName());
            allSellersResponseDto.setEmail(i.getSellerEmail());
            allSellersResponseDto.setMobile(i.getSellerMobile());
            allSellersResponseDto.setPanNumber(i.getSellerPanNumber());
            list1.add(allSellersResponseDto);
        }

        return list1;
    }


}
