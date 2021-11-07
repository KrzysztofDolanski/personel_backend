package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

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

    @ManyToMany
    @JoinTable (name = "item_warehouse", joinColumns = @JoinColumn(name = "idItem"),
            inverseJoinColumns = @JoinColumn(name = "idWarehouse"))
    private Set<Warehouse> warehouses;
}
