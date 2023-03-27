package com.Amazon.Amazon.ResponseDtos;

import com.Amazon.Amazon.Enum.CardType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardResponse {
    private String cardNo;
    private CardType cardType;
}
