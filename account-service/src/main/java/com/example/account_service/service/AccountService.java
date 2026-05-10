package com.example.account_service.service;

import com.example.account_service.client.AuthClient;
import com.example.account_service.entity.Account;
import com.example.account_service.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AccountService {

    @Autowired
    private AccountRepository repository;

    @Autowired
    private AuthClient authClient;

    public Account createAccount(Account account) {
        return repository.save(account);
    }

    public String callAuth(String authHeader) {
        return authClient.validateToken(authHeader);
    }

    public Account getAccount(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));
    }
}