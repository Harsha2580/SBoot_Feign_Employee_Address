package com.example.demo.addressRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
    Address findByEmployeeId(Long employeeId);
}

