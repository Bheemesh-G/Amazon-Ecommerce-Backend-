package com.Amazon.Amazon.ResponseDtos;


import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AllSellersResponseDto {
  //  private int id;
    private String name;

    private String email;

    private String mobile;

    private String panNumber;

}
