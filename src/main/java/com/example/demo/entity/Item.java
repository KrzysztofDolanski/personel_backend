package com.example.demo.entity;

import com.example.demo.dto.ItemSaveDto;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Item {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idItem;

    private String name;
    private Double quantity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idQuantityType")
    private QuantityType quantityType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idWarehouse")
    private Warehouse warehouse;

    public static Item of(ItemSaveDto itemDto) {
        Item item = new Item();
        item.setName(item.getName());
        item.setQuantity(item.getQuantity());
        return item;
    }
}
