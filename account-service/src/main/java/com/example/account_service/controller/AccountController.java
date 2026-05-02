package com.example.account_service.controller;

import com.example.account_service.entity.Account;
import com.example.account_service.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService service;

    @PostMapping
    public Account create(@RequestBody Account account) {
        return service.createAccount(account);
    }

    @GetMapping("/{id}")
    public Account get(@PathVariable Long id) {
        return service.getAccount(id);
    }
}