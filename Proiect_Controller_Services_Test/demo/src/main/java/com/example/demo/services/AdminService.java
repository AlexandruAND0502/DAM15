package com.example.demo.services;

import com.example.demo.magazin.Admin; // Correct import
import com.example.demo.repository.IAdmin;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    private final IAdmin adminRepository;

    public AdminService(IAdmin adminRepository) {
        this.adminRepository = adminRepository;
    }

    public Admin save(Admin admin) {
        return adminRepository.save(admin); // Should match
    }
     @SuppressWarnings("unchecked")
    public Iterable<Admin> findAll() {
        return (Iterable<Admin>) (Admin) adminRepository.findAll();
    }


    public Admin findById(Long id) {
        return (Admin) adminRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        adminRepository.deleteById(id);
    }
}