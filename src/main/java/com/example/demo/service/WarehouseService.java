package com.example.demo.service;

import com.example.demo.entity.Warehouse;
import com.example.demo.repository.WarehouseRepository;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WarehouseService {


    private final WarehouseRepository wareRepo;

    public Warehouse save(Warehouse warehouse) {
        return wareRepo.save(warehouse);
    }

    public List<Warehouse> getAll() {
        return wareRepo.findAll();
    }

    public ResponseEntity deleteById(Long id) {
        wareRepo.deleteById(id);
        if (wareRepo.findById(id).isPresent()){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }
}
