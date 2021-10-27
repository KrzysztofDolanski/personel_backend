package com.example.demo.controller;

import com.example.demo.entity.Warehouse;
import com.example.demo.service.WarehouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class WarehouseController {

    private final WarehouseService warehouseService;


    @PostMapping("/warehouses")
    public Warehouse saveNewWarehouse(@RequestBody Warehouse warehouse){
        return warehouseService.save(warehouse);
    }

    @GetMapping("/warehouses")
    public List<Warehouse> getAllWarehouses(){
        return warehouseService.getAll();
    }

    @DeleteMapping("/warehouses")
    public ResponseEntity deleteById(@RequestParam Long id){
        warehouseService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
