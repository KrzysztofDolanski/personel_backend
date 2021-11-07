package com.example.demo.controller;

import com.example.demo.dto.ItemDto;
import com.example.demo.entity.Item;
import com.example.demo.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ItemController {

    @Autowired
    private final ItemService itemService;

    @PostMapping("/items")
    public Item saveItem(@RequestBody Item item){
        return itemService.save(item);
    }

    @GetMapping("/items")
    public List<ItemDto> getAllItems(){
        return itemService.getAll().stream().map(ItemDto::of).collect(Collectors.toList());
    }

    @DeleteMapping("/items")
    public ResponseEntity deleteItem(@RequestParam Long id){
        itemService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
