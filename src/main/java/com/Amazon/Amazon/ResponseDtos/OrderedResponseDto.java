package com.Amazon.Amazon.ResponseDtos;


import com.Amazon.Amazon.Enum.CardType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderedResponseDto {
    private String productName;
    private Date orderedDate;
    private int totalCost;
    private int deliveryCharge;
    private String cardUsedForPayment;

    private int itemPrice;

    private int quantityOrdered;


}
