package com.test.accounts;

import com.test.accounts.domain.Account;
import com.test.accounts.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static java.util.stream.StreamSupport.stream;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class Accounts {

    private final AccountRepository accountRepository;

    @Autowired
    public Accounts(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @RequestMapping(value = "/accounts", method = GET)
    public List<Account> accounts() {
        return stream(accountRepository.findAll().spliterator(), false).collect(toList());
    }

    @RequestMapping(value = "/accounts/user/{id}", method = GET)
    public List<Account> accountsOwnedBy(@PathVariable("id") String owner) {
        return accountRepository.findByOwnedBy(owner);
    }

}