package com.example.demo.AddressFeignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entity.Address;

@FeignClient(name = "address-service", url = "http://localhost:8081")
public interface AddressFeignClient {
    @GetMapping("/addresses/employee/{employeeId}")
    ResponseEntity<Address> getAddressesByEmployeeId(@PathVariable("employeeId") Long employeeId);
}