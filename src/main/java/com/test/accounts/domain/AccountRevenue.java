package com.test.accounts.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "account_rev")
public class AccountRevenue {

    @Id
    @Column(name = "account_id")
    private Long accountId;

    private Long aggrev;

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getAggrev() {
        return aggrev;
    }

    public void setAggrev(Long aggrev) {
        this.aggrev = aggrev;
    }
}
