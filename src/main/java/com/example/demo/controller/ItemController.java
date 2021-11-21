package com.example.demo.controller;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.dto.ItemDto;
import com.example.demo.dto.ItemEditViewDto;
import com.example.demo.dto.ItemSaveDto;
import com.example.demo.entity.Item;
import com.example.demo.service.ItemService;
import com.example.demo.service.QuantityTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ItemController {

    final QuantityTypeService quantityTypeService;

    @Autowired
    private final ItemService itemService;

    @PostMapping("/items")
    public ItemDto saveItem(@RequestBody ItemSaveDto dto){
        if (dto.getIdItem()==null){
        return ItemDto.of(itemService.save(dto));
        } else {
            Item item = itemService.findById(dto.getIdItem()).get();
            item.setName(dto.getName());
            item.setQuantity(dto.getQuantity());
            item.setQuantityType(quantityTypeService.findById(dto.getIdQuantityType()).get());
            return ItemDto.of(itemService.save(ItemSaveDto.of(item)));
        }
    }

    @GetMapping("/items")
    public List<ItemDto> getAllItems(){
        return itemService.getAll().stream().map(ItemDto::of).collect(Collectors.toList());
    }

    @DeleteMapping("/items/{idItem}")
    public ResponseEntity deleteItem(@PathVariable Long idItem){
        itemService.deleteById(idItem);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/items/{idItem}")
    public ItemDto getItem(@PathVariable Long idItem) throws InterruptedException {
        Optional<Item> byId = itemService.findById(idItem);
        if (byId.isEmpty()){
            throw new RuntimeException("Something went wrong in get Item");
        };
        return ItemDto.of(byId.get());
    }

    @GetMapping("/item_edit_data/{idItem}")
    public ItemEditViewDto getItemEditDto(@PathVariable Long idIdem){
        Item itemDto = itemService.findById(idIdem).get();
        ItemEditViewDto editViewDto = ItemEditViewDto.of(itemDto, quantityTypeService.getAll());
        return editViewDto;
    }

}
