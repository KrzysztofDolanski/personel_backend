package com.example.demo.controller;

import com.example.demo.dto.WarehouseModuleDto;
import com.example.demo.entity.Warehouse;
import com.example.demo.service.WarehouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/warehouse_module_data")
    public WarehouseModuleDto getWarehouseModuleDto(@RequestParam Optional<String> idWarehouse){
        if (idWarehouse.isPresent()){
            return warehouseService.getWarehouseModuleDto(Long.parseLong(idWarehouse.get()));
        }else {
            return warehouseService.getWarehouseModuleDto();
        }

    }
}
