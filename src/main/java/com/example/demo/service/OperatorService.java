package com.example.demo.service;

import com.example.demo.entity.Operator;
import com.example.demo.repository.OperatorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OperatorService {

    private final OperatorRepository opRepo;

    public Operator save(Operator operator) {
        return opRepo.save(operator);
    }

    public List<Operator> findAll() {
        return opRepo.findAll();
    }

    public ResponseEntity deleteById(Long id) {
        opRepo.deleteById(id);
        if (opRepo.findById(id).isPresent()){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }
}
