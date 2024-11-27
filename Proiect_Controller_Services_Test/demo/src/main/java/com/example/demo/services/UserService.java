package com.example.demo.services;

import com.example.demo.magazin.User;
import com.example.demo.repository.IUser;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final IUser userRepository;

    public UserService(IUser userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}