package com.example.demo.addressController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.addressService.AddressService;
import com.example.demo.entity.Address;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    @Autowired
    private AddressService service;

    @PostMapping
    public ResponseEntity<Address> createAddress(@RequestBody Address address) {
        return new ResponseEntity<>(service.createAddress(address),HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Address>> getAllAddresses() {
        return new ResponseEntity<>(service.getAllAddresses(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable Long id) {
        Optional<Address> address = service.getAddressById(id);
        if(address.isPresent()){
            return new ResponseEntity<>(address.get(),HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<Address> getAddressesByEmployeeId(@PathVariable Long employeeId) {
        Address address = service.getAddressByEmployeeId(employeeId);
        if(address != null){
            return new ResponseEntity<>(address,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Address> updateAddress(@PathVariable Long id, @RequestBody Address add) {
        Optional<Address> address = service.getAddressById(id);
        if(address.isPresent()){
            return new ResponseEntity<>(service.updateAddress(id, add),HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Address> deleteAddress(@PathVariable Long id) {
        Optional<Address> address = service.getAddressById(id);
        if(address.isPresent()){
            service.deleteAddress(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
    }
}
