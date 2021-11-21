package com.example.demo.service;

import com.example.demo.dto.ItemDto;
import com.example.demo.dto.ItemSaveDto;
import com.example.demo.entity.Item;
import com.example.demo.entity.QuantityType;
import com.example.demo.entity.Warehouse;
import com.example.demo.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itRepo;
    private final WarehouseService warehouseService;
    private final QuantityTypeService quantityTypeService;

    public Item save(ItemSaveDto itemDto) {
        Optional<Warehouse> warehouseOptional = warehouseService.findById(itemDto.getIdWarehouse());
        Optional<QuantityType> quantityTypeOptional = quantityTypeService.findById(itemDto.getIdWarehouse());
        if (!warehouseOptional.isPresent() || !quantityTypeOptional.isPresent()){
            throw new RuntimeException("Incorrect id");
        }
        Warehouse warehouse = warehouseOptional.get();
        QuantityType quantityType = quantityTypeOptional.get();
        Item item = Item.of(itemDto);
        item.setQuantityType(quantityType);
        item.setWarehouse(warehouse);
        return itRepo.save(item);
    }

    public List<Item> getAll() {
        return itRepo.findAll();
    }

    public ResponseEntity deleteById(Long id) {
        itRepo.deleteById(id);
        if (itRepo.findById(id).isPresent()){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    public Optional<Item> findById(Long idItem) {
        return (itRepo.findById(idItem));
    }
}
