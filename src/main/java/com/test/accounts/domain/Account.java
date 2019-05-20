package com.test.accounts.domain;

import javax.persistence.*;

@Entity
@Table(name = "account")
@SecondaryTable(name = "account_rev", pkJoinColumns=@PrimaryKeyJoinColumn(name="account_id", referencedColumnName="id"))
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String description;

    @Column(table="account_rev", name="aggrev")
    private Long aggregatedRevenue;

    @Column(name = "owned_by")
    private String ownedBy;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getAggregatedRevenue() {
        return aggregatedRevenue;
    }

    public void setAggregatedRevenue(Long aggregatedRevenue) {
        this.aggregatedRevenue = aggregatedRevenue;
    }

    public String getOwnedBy() {
        return ownedBy;
    }

    public void setOwnedBy(String ownedBy) {
        this.ownedBy = ownedBy;
    }
}
