package com.employeedb.employeedb.service;

import com.employeedb.employeedb.dto.AdminDto;
import com.employeedb.employeedb.exceptions.NotFoundException;
import com.employeedb.employeedb.model.Admin;
import com.employeedb.employeedb.repository.AdminRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    private final AdminRepository adminRepository;

    public AdminService ( AdminRepository adminRepository ) {
        this.adminRepository = adminRepository;
    }

    public Admin registerAdmin (AdminDto adminDto) {
        Admin newAdmin = new Admin(adminDto.getName(), adminDto.getEmail(), adminDto.getPassword());
        return this.adminRepository.save(newAdmin);
    }

    public Admin getAdminByEmail (String email) {
        Admin admin = this.adminRepository.getAdminByEmail(email);
        if (admin == null ) { throw new NotFoundException("admin not found!!"); }
        return admin;
    }
}
