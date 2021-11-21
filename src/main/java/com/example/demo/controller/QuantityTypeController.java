package com.example.demo.controller;


import com.example.demo.dto.QuantityTypeDto;
import com.example.demo.entity.QuantityType;
import com.example.demo.service.QuantityTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class QuantityTypeController {

    private final QuantityTypeService quantityTypeService;


    @PostMapping("/quantity_types")
    public QuantityType saveNewQuantityType(@RequestBody QuantityType quantityType){
        return quantityTypeService.save(quantityType);
    }

    @GetMapping("/quantity_types")
    public List<QuantityTypeDto> getAllQuantityTypes(){
        return quantityTypeService.getAll().stream().map(QuantityTypeDto::of).collect(Collectors.toList());
    }

    @DeleteMapping("/quantity_types")
    public ResponseEntity deleteById(@RequestParam Long id){
        quantityTypeService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
