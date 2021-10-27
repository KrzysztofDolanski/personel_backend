package com.example.demo.controller;


import com.example.demo.entity.QuantityType;
import com.example.demo.service.QuantityTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class QuantityTypeController {

    private final QuantityTypeService quantityTypeService;


    @PostMapping("/quantitytypes")
    public QuantityType saveNewQuantityType(@RequestBody QuantityType quantityType){
        return quantityTypeService.save(quantityType);
    }

    @GetMapping("/quantitytypes")
    public List<QuantityType> getAllQuantityTypes(){
        return quantityTypeService.getAll();
    }

    @DeleteMapping("/quantitytypes")
    public ResponseEntity deleteById(@RequestParam Long id){
        quantityTypeService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
