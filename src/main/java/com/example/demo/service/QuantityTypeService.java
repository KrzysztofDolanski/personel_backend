package com.example.demo.service;

import com.example.demo.entity.QuantityType;
import com.example.demo.repository.QuantityTypeRepository;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuantityTypeService {

    private final QuantityTypeRepository quanRepo;

    public QuantityType save(QuantityType quantityType) {
        return quanRepo.save(quantityType);
    }

    public List<QuantityType> getAll() {
        return quanRepo.findAll();
    }

    public ResponseEntity deleteById(Long id) {
        quanRepo.deleteById(id);
        if (quanRepo.findById(id).isPresent()){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    public Optional<QuantityType> findById(Long idWarehouse) {
        return quanRepo.findById(idWarehouse);
    }
}
