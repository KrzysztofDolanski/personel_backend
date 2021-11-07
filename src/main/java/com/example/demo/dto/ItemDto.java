package com.example.demo.dto;

import com.example.demo.entity.Item;
import lombok.Data;

@Data
public class ItemDto {

    private Long idItem;
    private String name;
    private Double quantity;
    private String quantityType;

    public static ItemDto of(Item item){
        ItemDto itemDto = new ItemDto();
        itemDto.setIdItem(item.getIdItem());
        itemDto.setName(item.getName());
        itemDto.setQuantity(itemDto.getQuantity());
        itemDto.setQuantityType(item.getQuantityType().getName());
        return itemDto;
    }
}
