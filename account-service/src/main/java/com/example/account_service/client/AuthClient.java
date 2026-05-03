package com.example.account_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "auth-service", url = "http://auth-service:8082")
public interface AuthClient {

    @GetMapping("/auth/test")
    String testAuth();
}