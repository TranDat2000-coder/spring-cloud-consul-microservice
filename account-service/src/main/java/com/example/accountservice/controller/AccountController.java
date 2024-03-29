package com.example.accountservice.controller;

import com.example.accountservice.exception.BalanceNotEnoughException;
import com.example.accountservice.model.Account;
import com.example.accountservice.repository.AccountRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/account-api")
public class AccountController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountController.class);

    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    AccountRepository repository;

    @PostMapping("/")
    public Account add(@RequestBody Account account) {
        return repository.add(account);
    }

    @PutMapping
    public Account update(@RequestBody Account account) {
        return repository.update(account);
    }

    @PutMapping("/withdraw/{id}/{amount}")
    public Account withdraw(@PathVariable("id") Long id, @PathVariable("amount") int amount) throws JsonProcessingException {
        Account account = repository.findById(id);
        if (amount > account.getBalance())
            throw new BalanceNotEnoughException("Not enough funds: id=" + id + ", amount=" + amount);
        LOGGER.info("Account found: {}", mapper.writeValueAsString(account));
        account.setBalance(account.getBalance() - amount);
        LOGGER.info("Current balance: {}", mapper.writeValueAsString(Collections.singletonMap("balance", account.getBalance())));
        return repository.update(account);
    }

    @GetMapping("/{id}")
    public Account findById(@RequestParam("id") Long id) {
        return repository.findById(id);
    }

    @GetMapping("/customer/{customerId}")
    public List<Account> findByCustomerId(@RequestParam("customerId") Long customerId) {
        return repository.findByCustomer(customerId);
    }

    @PostMapping("/ids")
    public List<Account> find(@RequestBody List<Long> ids) {
        return repository.find(ids);
    }

    @DeleteMapping("/{id}")
    public void delete(@RequestParam("id") Long id) {
        repository.delete(id);
    }
}
