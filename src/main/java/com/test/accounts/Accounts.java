package com.test.accounts;

import com.test.accounts.domain.Account;
import com.test.accounts.domain.AccountWrapper;
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
    public AccountWrapper accounts() {
        List<Account> accounts = stream(accountRepository.findAll().spliterator(), false).collect(toList());
        AccountWrapper accountWrapper = new AccountWrapper();
        accountWrapper.setAccounts(accounts);
        return accountWrapper;
    }

    @RequestMapping(value = "/accounts/user/{user}", method = GET)
    public AccountWrapper accountsOwnedBy(@PathVariable("user") String owner) {
        List<Account> accountsOwned = accountRepository.findByOwnedBy(owner);
        AccountWrapper accountWrapper = new AccountWrapper();
        accountWrapper.setAccounts(accountsOwned);
        return accountWrapper;
    }

}