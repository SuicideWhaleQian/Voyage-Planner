package com.example.navigation.service;

import com.example.navigation.entity.User;
import com.example.navigation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() ->
                new RuntimeException("用户不存在"));
    }

    public User save(User user) {
        return userRepository.save(user);
    }
}