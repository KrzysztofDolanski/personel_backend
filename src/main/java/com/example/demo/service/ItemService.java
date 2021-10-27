package com.example.demo.service;

import com.example.demo.entity.Item;
import com.example.demo.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itRepo;

    public Item save(Item item) {
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
}
