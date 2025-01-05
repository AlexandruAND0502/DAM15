package com.example.demo.Services;

import com.example.demo.Entity.User;
import com.example.demo.Repository.IUser;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final IUser userRepository;

    public UserService(IUser userRepository) {
        this.userRepository = userRepository;
    }

    // Salvare User
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // Găsire User după ID
    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    // Actualizare User
    public User updateUser(Long id, User updatedUser) {
        return userRepository.findById(id).map(user -> {
            user.setUsername(updatedUser.getUsername());
            user.setPassword(updatedUser.getPassword());
            user.setEmail(updatedUser.getEmail());
            user.setRole(updatedUser.getRole());
            return userRepository.save(user);
        }).orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    // Ștergere User
    public void deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            throw new RuntimeException("User not found with id: " + id);
        }
    }
}
