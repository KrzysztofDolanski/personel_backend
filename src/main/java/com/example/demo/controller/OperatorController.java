package com.example.demo.controller;

import com.example.demo.entity.Operator;
import com.example.demo.service.OperatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OperatorController {

    private final OperatorService operatorService;

    @PostMapping("/operators")
    public Operator saveOperator(@RequestBody Operator operator){
        return operatorService.save(operator);
    }

    @GetMapping("/operators")
    public List<Operator> findAllOperators(){
        return operatorService.findAll();
    }

    @DeleteMapping("/operators")
    public ResponseEntity deleteOperatorById(@RequestParam Long id){
        operatorService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
