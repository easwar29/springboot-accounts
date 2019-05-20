package com.test.accounts.repository;

import com.test.accounts.domain.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountRepository extends CrudRepository<Account, Long> {

    List<Account> findByOwnedBy(String ownedBy);

}