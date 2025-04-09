package com.employeedb.employeedb.controller;

import com.employeedb.employeedb.dto.EmployeeDto;
import com.employeedb.employeedb.service.EmployeeService;
import com.employeedb.employeedb.model.Employee;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<Employee> getEmployee (@PathVariable int id) throws ChangeSetPersister.NotFoundException {
        Employee employee = this.employeeService.getEmployee(id);
        return ResponseEntity.status(HttpStatus.OK).body(employee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee (@RequestBody EmployeeDto employeeDto ,@PathVariable int id) throws ChangeSetPersister.NotFoundException {
        Employee employee = this.employeeService.updateEmployee(employeeDto, id);
        return ResponseEntity.status(HttpStatus.OK).body(employee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee (@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.employeeService.deleteEmployee(id));
    }

}
