package com.employeedb.employeedb.repository;

import com.employeedb.employeedb.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
