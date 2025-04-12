package com.employeedb.employeedb.repository;

import com.employeedb.employeedb.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
    Admin getAdminByEmail(String email);
}
