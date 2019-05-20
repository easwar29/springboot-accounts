package com.test.accounts;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.accounts.domain.AccountRevenue;
import com.test.accounts.domain.CustomerRevenueUpdatedEvent;
import com.test.accounts.repository.AccountRevenueRepository;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class UpdateAccountRevenue {

    private final AccountRevenueRepository accountRevenueRepository;
    private ObjectMapper objectMapper = new ObjectMapper();

    public UpdateAccountRevenue(AccountRevenueRepository accountRevenueRepository) {
        this.accountRevenueRepository = accountRevenueRepository;
    }

    public void updateRevenue(String message) throws IOException {
        CustomerRevenueUpdatedEvent customerRevenueUpdatedEvent = objectMapper.readValue(message, CustomerRevenueUpdatedEvent.class);
        AccountRevenue accountRevenue = new AccountRevenue();
        accountRevenue.setAggrev(customerRevenueUpdatedEvent.getAggregatedRevenue());
        accountRevenue.setAccountId(customerRevenueUpdatedEvent.getAccountId());
        accountRevenueRepository.save(accountRevenue);
    }
}
