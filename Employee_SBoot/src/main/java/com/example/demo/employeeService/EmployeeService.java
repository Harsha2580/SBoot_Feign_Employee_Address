package com.example.demo.employeeService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.AddressFeignClient.AddressFeignClient;
import com.example.demo.employeeRepository.EmployeeRepository;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Address;
@Service
public class EmployeeService {
    @Autowired
    private  EmployeeRepository repository;
    @Autowired
    private AddressFeignClient addressFeignClient;

    public Employee createEmployee(Employee employee) {
        return repository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        updatedEmployee.setEmpId(id);
        return repository.save(updatedEmployee);
    }

    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }

    
    public Optional<Employee> getEmployeeById(Long id) {
        Optional<Employee> employee = repository.findById(id);
        // Fetch the addresses using Feign client
        ResponseEntity<Address> address = addressFeignClient.getAddressesByEmployeeId(id);
        employee.get().setAddresses(address.getBody());

        return employee;

    }
}
