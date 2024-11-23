package com.example.demo.entity;


import jakarta.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empId;
    private String name;
    private int age;
    private double salary;
    private String role;

    @Transient
    private Address addresses;

    public Long getEmpId() {
        return empId;
    }
    public void setEmpId(Long empId) {
        this.empId = empId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public Employee(Long empId, String name, int age, double salary, String role) {
        this.empId = empId;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.role = role;
    }
    public Employee() {
        super();
    }
    @Override
    public String toString() {
        return "Employee [empId=" + empId + ", name=" + name + ", age=" + age + ", salary=" + salary + ", role=" + role
                + "]";
    }
    public Address getAddresses() {
        return addresses;
    }
    public void setAddresses(Address addresses) {
        this.addresses = addresses;
    }

}