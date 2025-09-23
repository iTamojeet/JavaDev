package com.example.service;

import com.example.entity.Account;
import com.example.repository.AccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository repository;

    public Account create(String owner, double balance) {
        return repository.save(new Account(owner, balance));
    }

    public Account get(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public List<Account> getAll() {
        return repository.findAll();
    }

    @Transactional
    public void deposit(Long id, double amount) {
        Account account = repository.findById(id).orElseThrow();
        account.setBalance(account.getBalance() + amount);
        repository.save(account);
    }

    @Transactional
    public void withdraw(Long id, double amount) {
        Account account = repository.findById(id).orElseThrow();
        if (account.getBalance() < amount) {
            throw new IllegalArgumentException("Insufficient balance");
        }
        account.setBalance(account.getBalance() - amount);
        repository.save(account);
    }

    @Transactional
    public void transfer(Long fromId, Long toId, double amount) {
        Account from = repository.findById(fromId).orElseThrow();
        Account to = repository.findById(toId).orElseThrow();

        if (from.getBalance() < amount) {
            throw new IllegalArgumentException("Insufficient balance");
        }

        from.setBalance(from.getBalance() - amount);
        to.setBalance(to.getBalance() + amount);

        repository.save(from);
        repository.save(to);
    }
}
