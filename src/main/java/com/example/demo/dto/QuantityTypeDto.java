package com.example.demo.dto;

import com.example.demo.entity.QuantityType;
import lombok.Data;

@Data
public class QuantityTypeDto {

    private Long idQuantityType;
    private String name;


    public static QuantityTypeDto of(QuantityType quantityType){
        QuantityTypeDto quantityTypeDto = new QuantityTypeDto();
        quantityTypeDto.setName(quantityType.getName());
        quantityTypeDto.setIdQuantityType(quantityType.getIdQuantityType());
        return quantityTypeDto;
    }
}
