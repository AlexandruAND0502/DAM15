package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.Entity.Admin;
import com.example.demo.Repository.IAdmin;

@Service
public class AdminService {

    private final IAdmin adminRepository;
    
    public AdminService(IAdmin adminRepository) {
        this.adminRepository = adminRepository;
    }

    // Create a new Admin
    public Admin createAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    // Get all Admins
    public List<Admin> getAllAdmins() {
        return (List<Admin>) adminRepository.findAll();
    }

    // Get an Admin by ID
    public Optional<Admin> getAdminById(Long id) {
        return adminRepository.findById(id);
    }

    // Update an Admin
    public Admin updateAdmin(Long id, Admin updatedAdmin) {
        return adminRepository.findById(id).map(admin -> {
            admin.setName(updatedAdmin.getName());
            admin.setDateOfEmployment(updatedAdmin.getDateOfEmployment());
            return adminRepository.save(admin);
        }).orElseThrow(() -> new RuntimeException("Admin not found with id: " + id));
    }

    // Delete an Admin
    public void deleteAdmin(Long id) {
        if (adminRepository.existsById(id)) {
            adminRepository.deleteById(id);
        } else {
            throw new RuntimeException("Admin not found with id: " + id);
        }
    }
}
