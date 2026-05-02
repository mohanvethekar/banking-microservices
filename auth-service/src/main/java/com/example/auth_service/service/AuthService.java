package com.example.auth_service.service;

import com.example.auth_service.dto.LoginRequest;
import com.example.auth_service.dto.RegisterRequest;
import com.example.auth_service.entity.User;
import com.example.auth_service.repository.UserRepository;
import com.example.auth_service.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    public String register(RegisterRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword()); // later we will encrypt
        user.setRole("USER");

        userRepository.save(user);
        return "User registered successfully";
    }

    public String login(LoginRequest request) {
        try {
            System.out.println("Incoming username: " + request.getUsername());
            System.out.println("Incoming password: " + request.getPassword());

            User user = userRepository.findByUsername(request.getUsername())
                    .orElseThrow(() -> new RuntimeException("User not found"));

            System.out.println("DB password: " + user.getPassword());

            if (!user.getPassword().equals(request.getPassword())) {
                throw new RuntimeException("Invalid credentials");
            }

            String token = jwtUtil.generateToken(user.getUsername());
            System.out.println("Generated token: " + token);

            return token;

        } catch (Exception e) {
            e.printStackTrace(); // 🔥 THIS IS KEY
            throw e;
        }
    }
}