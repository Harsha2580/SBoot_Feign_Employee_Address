package com.example.demo;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

import com.example.demo.entity.Employee;
import com.example.demo.employeeRepository.EmployeeRepository;
import com.example.demo.employeeService.EmployeeService;

class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    private Employee employee;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        employee = new Employee();
        employee.setEmpId(1L);
        employee.setName("Alex");
        employee.setAge(25);
        employee.setSalary(90000);
        employee.setRole("Developer");
    }

    @Test
    void testToGetAllEmployees() {
        when(employeeRepository.findAll()).thenReturn(Arrays.asList(employee));
        assertEquals(1, employeeService.getAllEmployees().size());
    }

    @Test
    void testToGetEmployeeById() {
        when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee));
        Optional<Employee> res = employeeService.getEmployeeById(1L);
        assertTrue(res.isPresent());
        assertEquals("Alex", res.get().getName());
        assertEquals("Developer", res.get().getRole());
    }

    @Test
    void testToCreateEmployee() {
        when(employeeRepository.save(any(Employee.class))).thenReturn(employee);
        Employee created = employeeService.createEmployee(employee);
        assertNotNull(created);
        assertEquals("Alex", created.getName());
        assertEquals("Developer", created.getRole());
    }

    @Test
    void testToUpdateEmployee() {
        when(employeeRepository.save(any(Employee.class))).thenReturn(employee);
        Employee updated = employeeService.updateEmployee(1L, employee);
        assertNotNull(updated);
        assertEquals("Alex", updated.getName());
        assertEquals("Developer", updated.getRole());
    }

    @Test
    void testToDeleteEmployee() {
        doNothing().when(employeeRepository).deleteById(1L);
        employeeService.deleteEmployee(1L);
        assertEquals(0, employeeService.getAllEmployees().size());
    }
}
