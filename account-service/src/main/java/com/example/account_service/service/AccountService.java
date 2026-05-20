package com.example.account_service.service;

import com.example.account_service.client.AuthClient;
import com.example.account_service.entity.Account;
import com.example.account_service.repository.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AccountService {

    @Autowired
    private AccountRepository repository;

    @Autowired
    private AuthClient authClient;

    private static Logger log = LoggerFactory.getLogger(AuthClient.class);

    public Account createAccount(Account account) {
        log.debug("Create Account Details" + account);

        return repository.save(account);
    }

    public String callAuth(String authHeader) {
        log.debug("Callig Auth for feing client with authHeader "+ authHeader);
        return authClient.validateToken(authHeader);
    }

    public Account getAccount(Long id) {
        log.debug("Getting Account for Id"+id);
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));
    }
}