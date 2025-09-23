package com.example.controller;

import com.example.entity.Account;
import com.example.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService service;

    // Create account via JSON body
    @PostMapping
    public Account create(@RequestBody Account account) {
        return service.create(account.getOwnerName(), account.getBalance());
    }

    // Get account by ID
    @GetMapping("/{id}")
    public Account get(@PathVariable Long id) {
        return service.get(id);
    }

    // Get all accounts
    @GetMapping
    public List<Account> getAll() {
        return service.getAll();
    }

    // Deposit
    @PostMapping("/deposit/{id}/{amount}")
    public String deposit(@PathVariable Long id, @PathVariable double amount) {
        service.deposit(id, amount);
        return "Deposit successful";
    }

    // Withdraw
    @PostMapping("/withdraw/{id}/{amount}")
    public String withdraw(@PathVariable Long id, @PathVariable double amount) {
        try {
            service.withdraw(id, amount);
            return "Withdrawal successful";
        } catch (IllegalArgumentException e) {
            return "Insufficient balance. Transaction rolled back!";
        }
    }

    // Transfer
    @PostMapping("/transfer/{fromId}/{toId}/{amount}")
    public String transfer(@PathVariable Long fromId, @PathVariable Long toId, @PathVariable double amount) {
        try {
            service.transfer(fromId, toId, amount);
            return "Transfer successful";
        } catch (IllegalArgumentException e) {
            return "Transfer failed: " + e.getMessage();
        }
    }
}
