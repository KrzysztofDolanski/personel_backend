package com.example.demo.service;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {


    private final EmployeeRepository empRepo;

    public Employee save(EmployeeDto employee) {
        return empRepo.save(Employee.of(employee));
    }

    public List<Employee> findAll() {
        return empRepo.findAll();
    }

    public ResponseEntity deleteById(Long id) {
        empRepo.deleteById(id);
        if (empRepo.findById(id).isPresent()){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    public Employee findById(Long id) {
        return empRepo.findById(id).orElseThrow();
    }

}
