package com.employeedb.employeedb.controller;


import com.employeedb.employeedb.dto.AdminDto;
import com.employeedb.employeedb.dto.AdminLoginDto;
import com.employeedb.employeedb.model.Admin;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.employeedb.employeedb.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController ( AuthService authService ) {
        this.authService = authService;
    }

    @PostMapping("/register-admin")
    public ResponseEntity<Admin> registerAdmin (@RequestBody AdminDto adminDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.authService.registerAdmin(adminDto));
    }

    @PostMapping("/login_admin")
    public ResponseEntity<?> loginAdmin (@RequestBody AdminLoginDto adminLoginDto) {
        return ResponseEntity.status(HttpStatus.OK).body(this.loginAdmin(adminLoginDto));
    }
}
