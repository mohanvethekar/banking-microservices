package com.example.auth_service.controller;

import com.example.auth_service.dto.AuthResponse;
import com.example.auth_service.dto.LoginRequest;
import com.example.auth_service.dto.RegisterRequest;
import com.example.auth_service.service.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    private static Logger log = LoggerFactory.getLogger(AuthService.class);

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {
        log.debug("Registering User with Details "+request);
        return authService.register(request);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {
        String token = authService.login(request);
        return new AuthResponse(token);
    }

    @GetMapping("/test")
    public String test() {
        return "JWT is working";
    }
}