package com.employeedb.employeedb.config;

import com.employeedb.employeedb.service.AdminService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class ApplicationConfig {

    private final AdminService adminService;

    public ApplicationConfig ( AdminService adminService ) {
        this.adminService = adminService;
    }

    @Bean
    public UserDetailsService userDetailsService () {
        return username -> this.adminService.getAdminByEmail(username);

    }
}
