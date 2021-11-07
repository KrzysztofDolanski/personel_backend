package com.example.demo.dto;

import com.example.demo.entity.Operator;
import lombok.Data;

@Data
public class OperatorAuthenticationResultDto {
    private Long idOperator;
    private String firstName;
    private String lastName;
    private boolean authenticated;


    public static OperatorAuthenticationResultDto createUnauthenticated(){
        OperatorAuthenticationResultDto operator = new OperatorAuthenticationResultDto();
        operator.setAuthenticated(false);
        return operator;
    }


    public static OperatorAuthenticationResultDto of(Operator operator){
        OperatorAuthenticationResultDto operatorAuthenticationResultDto = new OperatorAuthenticationResultDto();
        operatorAuthenticationResultDto.setAuthenticated(true);
        operatorAuthenticationResultDto.setFirstName(operator.getEmployee().getFirstName());
        operatorAuthenticationResultDto.setLastName(operator.getEmployee().getLastName());
        operatorAuthenticationResultDto.setIdOperator(operator.getIdOperator());
        return operatorAuthenticationResultDto;
    }
}
