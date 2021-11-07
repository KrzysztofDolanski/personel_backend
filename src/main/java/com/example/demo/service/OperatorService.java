package com.example.demo.service;

import com.example.demo.dto.OperatorAuthenticationResultDto;
import com.example.demo.dto.OperatorCredentialsDto;
import com.example.demo.entity.Operator;
import com.example.demo.repository.OperatorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public OperatorAuthenticationResultDto findByLogin(OperatorCredentialsDto operator, String login) {
        Optional<Operator> byLogin = opRepo.findByLogin(login);
        if (!byLogin.isPresent()){
            return OperatorAuthenticationResultDto.createUnauthenticated();
        }
        Operator operatorToCheck = byLogin.get();
        if (!operatorToCheck.getPassword().equals(operator.getPassword())){
            return OperatorAuthenticationResultDto.createUnauthenticated();
        } else return OperatorAuthenticationResultDto.of(operatorToCheck);
    }
}
