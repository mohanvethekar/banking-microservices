package com.example.auth_service.dto;

public class AuthResponse {
    public String getToken() {
        return token;
    }

    public AuthResponse(String token) {
        this.token = token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    private String token;
}