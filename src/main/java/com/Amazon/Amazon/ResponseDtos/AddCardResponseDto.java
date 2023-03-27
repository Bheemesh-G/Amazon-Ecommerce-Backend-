package com.Amazon.Amazon.ResponseDtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddCardResponseDto {
    private String name;
    private List<CardResponse> list = new ArrayList<>();
}
