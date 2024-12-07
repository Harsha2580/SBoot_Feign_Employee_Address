package com.example.demo.addressRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Address;
@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    Address findByEmployeeId(Long employeeId);
}

