package com.employeedb.employeedb.service;


import com.employeedb.employeedb.dto.EmployeeDto;
import com.employeedb.employeedb.model.Employee;
import com.employeedb.employeedb.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService ( EmployeeRepository employeeRepository ) {
        this.employeeRepository = employeeRepository;
    }

    public Employee createUser (EmployeeDto employeeDto) {
        Employee newEmployee = new Employee (employeeDto.getName(), employeeDto.getEmail(), employeeDto.getPhone());
        return employeeRepository.save(newEmployee);
    }

    public List<Employee> getAllUsers () {
        List<Employee> employees = employeeRepository.findAll();
        return employees;
    }

    public Optional<Employee> getEmployee (int id ) {
        return this.employeeRepository.findById(id);
    }
}
