package com.employeedb.employeedb.service;

import com.employeedb.employeedb.dto.EmployeeDto;
import com.employeedb.employeedb.model.Employee;
import com.employeedb.employeedb.repository.EmployeeRepository;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
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

    public Employee getEmployee (int id ) throws NotFoundException {
        return this.employeeRepository.findById(id).orElseThrow(() -> new NotFoundException());
    }

    public Employee updateEmployee ( EmployeeDto employeeDto, int id ) throws NotFoundException {
        Employee employee = this.getEmployee(id);
        employee.setEmail(employeeDto.getEmail());
        employee.setName(employeeDto.getName());
        employee.setPhone(employeeDto.getPhone());
        return employeeRepository.save(employee);
    }

    public String deleteEmployee ( int id ) {
        this.employeeRepository.deleteById(id);
        return "Employee Deleted";
    }
}
