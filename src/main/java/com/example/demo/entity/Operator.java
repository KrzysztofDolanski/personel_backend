package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Operator {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOperator;

    @Column
    private String login;
    @Column
    private String password;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_employee")
    private Employee employee;

}

