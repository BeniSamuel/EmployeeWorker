package com.employeedb.employeedb.service;

import com.employeedb.employeedb.dto.AdminDto;
import com.employeedb.employeedb.dto.AdminLoginDto;
import com.employeedb.employeedb.model.Admin;
import com.employeedb.employeedb.repository.AdminRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final AdminService adminService;

    public AuthService ( AdminService adminService ) {
        this.adminService = adminService;
    }

    public Admin registerAdmin (AdminDto adminDto) {
        return this.adminService.registerAdmin(adminDto);
    }

    public String loginAdmin (AdminLoginDto adminLoginDto) {

    }
}
