package com.example.account_service.controller;

import com.example.account_service.entity.Account;
import com.example.account_service.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService service;

    private static Logger log = LoggerFactory.getLogger(AccountController.class);

    @PostMapping
    public Account create(@RequestBody Account account) {
        log.info("Recieved request for Account creation");
        return service.createAccount(account);
    }

    @GetMapping("/{id}")
    public Account get(@PathVariable Long id) {
        return service.getAccount(id);
    }

    @GetMapping("/test")
    public String test(@RequestHeader("Authorization") String authHeader){
        log.info("Recieved request for testing Feing with token " + authHeader);
        return service.callAuth(authHeader);
    }
}