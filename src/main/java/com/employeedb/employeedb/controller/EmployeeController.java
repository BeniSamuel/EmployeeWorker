package com.employeedb.employeedb.controller;

import com.employeedb.employeedb.dto.EmployeeDto;
import com.employeedb.employeedb.service.EmployeeService;
import com.employeedb.employeedb.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController ( EmployeeService employeeService ) {
        this.employeeService = employeeService;
    }

    @PostMapping()
    public ResponseEntity<Employee> createEmployee (@RequestBody EmployeeDto employeeDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.employeeService.createUser(employeeDto));
    }

    @GetMapping()
    public ResponseEntity<List<Employee>> getAllEmployees () {
        return ResponseEntity.status(HttpStatus.OK).body(this.employeeService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Employee>> getEmployee (@PathVariable int id) {
        Optional<Employee> employee = this.employeeService.getEmployee(id);
        if (employee.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(employee);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(employee);
        }

    }
}
