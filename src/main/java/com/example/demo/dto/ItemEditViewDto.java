package com.example.demo.dto;

import com.example.demo.entity.Item;
import com.example.demo.entity.QuantityType;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class ItemEditViewDto {

    private Long idItem;
    private String name;
    private Double quantity;
    private Long idQuantityType;
    private List<QuantityTypeDto> quantityTypeDtoList;


    public static ItemEditViewDto of(Item item, List<QuantityType> quantityTypeDtoList){
        ItemEditViewDto itemEditViewDto = new ItemEditViewDto();
         itemEditViewDto.setIdItem(item.getIdItem());
         itemEditViewDto.setName(item.getName());
         itemEditViewDto.setQuantity(item.getQuantity());
         itemEditViewDto.setIdQuantityType(item.getQuantityType().getIdQuantityType());
         itemEditViewDto.setQuantityTypeDtoList(quantityTypeDtoList.stream().map(QuantityTypeDto::of).collect(Collectors.toList()));
         return itemEditViewDto;
    }
}
