package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;

@Entity
@SuppressWarnings("unused")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonProperty("employeeId")
    private Long employeeId;
    private String doorNo;
    private String street;
    private String city;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }
    public String getDoorNo() {
        return doorNo;
    }
    public void setDoorNo(String doorNo) {
        this.doorNo = doorNo;
    }
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public Address(Long id, Long employeeId, String doorNo, String street, String city) {
        this.id = id;
        this.employeeId = employeeId;
        this.doorNo = doorNo;
        this.street = street;
        this.city = city;
    }
    public Address() {
        super();
    }
    @Override
    public String toString() {
        return "Address [id=" + id + ", employeeId=" + employeeId + ", doorNo=" + doorNo + ", street=" + street
                + ", city=" + city + "]";
    }
    
}
