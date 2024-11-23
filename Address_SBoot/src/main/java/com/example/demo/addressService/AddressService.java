package com.example.demo.addressService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.addressRepository.AddressRepository;
import com.example.demo.entity.Address;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    private AddressRepository repository;

    public Address createAddress(Address address) {
        return repository.save(address);
    }

    public List<Address> getAllAddresses() {
        return repository.findAll();
    }

    public Optional<Address> getAddressById(Long id) {
        return repository.findById(id);
    }

    public Address updateAddress(Long id, Address updatedAddress) {
        updatedAddress.setId(id);
        return repository.save(updatedAddress);
    }

    public void deleteAddress(Long id) {
        repository.deleteById(id);
    }

    public Address getAddressByEmployeeId(Long employeeId) {
        return repository.findByEmployeeId(employeeId);
    }
}

