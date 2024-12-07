package com.example.demo.entity;

import lombok.Data;

@SuppressWarnings("unused")
@Data
public class Address {
    private Long id;
    private Long employeeId;
    private String doorNo;
    private String street;
    private String city;
}
