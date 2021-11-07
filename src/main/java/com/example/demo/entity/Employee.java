package com.example.demo.entity;

import com.example.demo.dto.EmployeeDto;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmployee;
    @Column
    private String firstName;
    @Column
    private String lastName;

    @Column
    private String salary;


    @OneToOne(mappedBy = "employee")
    private Operator operator;


    public static Employee of(EmployeeDto employee){
        Employee em = new Employee();
        em.setIdEmployee(employee.getIdEmployee());
        em.setFirstName(employee.getFirstName());
        em.setLastName(employee.getLastName());
        em.setSalary(employee.getSalary());
        return em;
    }
}
