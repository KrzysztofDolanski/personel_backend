package com.example.demo.controller;

import com.example.demo.entity.Item;
import com.example.demo.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<Item> getAllItems(){
        return itemService.getAll();
    }

    @DeleteMapping("/items")
    public ResponseEntity deleteItem(@RequestParam Long id){
        itemService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
