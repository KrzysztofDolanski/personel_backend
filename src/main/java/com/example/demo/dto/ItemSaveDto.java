package com.example.demo.dto;

import com.example.demo.entity.Item;
import lombok.Data;

@Data
public class ItemSaveDto {

    private Long idItem;
    private String name;
    private Double quantity;
    private Long idQuantityType;
    private Long idWarehouse;


    public static ItemSaveDto of(Item item){
        ItemSaveDto itemSaveDto = new ItemSaveDto();
        itemSaveDto.setIdItem(item.getIdItem());
        itemSaveDto.setName(item.getName());
        itemSaveDto.setQuantity(item.getQuantity());
        itemSaveDto.setIdQuantityType(item.getQuantityType().getIdQuantityType());
        itemSaveDto.setIdWarehouse(item.getWarehouse().getIdWarehouse());
        return itemSaveDto;
    }
}
