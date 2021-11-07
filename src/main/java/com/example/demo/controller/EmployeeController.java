package com.example.demo.controller;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class EmployeeController {


    @Autowired
    private final EmployeeService empServ;

    @PostMapping("/employees")
    public EmployeeDto newEmployee(@RequestBody EmployeeDto dto){
        return EmployeeDto.of(empServ.save(dto));
    }


    @GetMapping("/employees")
    public List<EmployeeDto> getAllEmployees(){
        return empServ.findAll().stream()
                .map(EmployeeDto::of)
                .collect(Collectors.toList());
    }

    @GetMapping("/employees/{idEmployee}")
    public EmployeeDto getEmployee(@PathVariable Long idEmployee) throws InterruptedException {
        Thread.sleep(500);
        return EmployeeDto.of(empServ.findById(idEmployee));
    }

    @DeleteMapping("/employees")
    public ResponseEntity deleteEmployee(@RequestBody Long id){
        empServ.deleteById(id);
        return ResponseEntity.ok().build();
    }




}
