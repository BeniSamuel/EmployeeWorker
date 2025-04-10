package com.employeedb.employeedb.service;

import com.employeedb.employeedb.dto.AdminDto;
import com.employeedb.employeedb.dto.AdminLoginDto;
import com.employeedb.employeedb.exceptions.UnAuthorizedException;
import com.employeedb.employeedb.model.Admin;
import com.employeedb.employeedb.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final AdminService adminService;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    private JwtUtil jwtUtil;

    public AuthService ( AdminService adminService, PasswordEncoder passwordEncoder ) {
        this.adminService = adminService;
        this.passwordEncoder = passwordEncoder;
    }

    public Admin registerAdmin (AdminDto adminDto) {
        return this.adminService.registerAdmin(adminDto);
    }

    public String loginAdmin (AdminLoginDto adminLoginDto) {
        Admin admin = this.adminService.getAdminByEmail(adminLoginDto.getEmail());

        if (!passwordEncoder.matches(adminLoginDto.getPassword(),admin.getPassword())) {
            throw new UnAuthorizedException("Invalid Credentials");
        }

        return jwtUtil.generateToken(admin.getEmail());
    }
}
