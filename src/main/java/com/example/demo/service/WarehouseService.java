package com.example.demo.service;

import com.example.demo.dto.ItemDto;
import com.example.demo.dto.WarehouseDto;
import com.example.demo.dto.WarehouseModuleDto;
import com.example.demo.entity.Warehouse;
import com.example.demo.repository.WarehouseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public WarehouseModuleDto getWarehouseModuleDto(){
        List<Warehouse> warehouseList = wareRepo.findAll();
        List<WarehouseDto> warehouseDtoList = warehouseList.stream().map(WarehouseDto::of).collect(Collectors.toList());
        List<ItemDto> itemDtoList = warehouseList.get(0).getItems().stream().map(ItemDto::of).collect(Collectors.toList());
        WarehouseDto selectedWarehouseDto = WarehouseDto.of(warehouseList.get(0));
        WarehouseModuleDto warehouseModuleDto = new WarehouseModuleDto(selectedWarehouseDto, warehouseDtoList, itemDtoList);
        return warehouseModuleDto;
    }


    public WarehouseModuleDto getWarehouseModuleDto(Long idWarehouse){
        List<Warehouse> warehouseList = wareRepo.findAll();
        List<WarehouseDto> warehouseDtoList = warehouseList.stream().map(WarehouseDto::of).collect(Collectors.toList());
        Warehouse selectedWarehouse = warehouseList.stream().filter(x -> idWarehouse.equals(x.getIdWarehouse())).findFirst().orElseThrow();
        WarehouseDto selectedWarehouseDto = WarehouseDto.of(selectedWarehouse);
        List<ItemDto> itemDtoList = selectedWarehouse.getItems().stream().map(ItemDto::of).collect(Collectors.toList());
        WarehouseModuleDto warehouseModuleDto = new WarehouseModuleDto(selectedWarehouseDto, warehouseDtoList, itemDtoList);
        return warehouseModuleDto;
    }

    public Optional<Warehouse> findById(Long idWarehouse) {
        return wareRepo.findById(idWarehouse);
    }
}
