package com.Amazon.Amazon.RequestDtos;


import com.Amazon.Amazon.Enum.CardType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddCardRequestDto {
    private int customerId;
    private String cardNo;
    private int cvv;
    private CardType cardType;
}
