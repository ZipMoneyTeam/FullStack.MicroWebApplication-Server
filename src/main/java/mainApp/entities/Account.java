package mainApp.entities;

import javax.persistence.*;


@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long accountId;
    String accountName;
    Long accountNumber;  // how to increment auto generate
    String accountType;
    Double amount;
    @ManyToOne(targetEntity=AppUser.class, fetch=FetchType.EAGER)
    AppUser userId;

    public Account() {
    }

    public Account(Long accountId, String accountName, Long accountNumber, String accountType, Double amount, AppUser appUser) {
        this.accountId = accountId;
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.amount = amount;
        this.userId = appUser;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public AppUser getAppUser() {
        return userId;
    }

    public void setAppUser(AppUser appUser) {
        this.userId = appUser;
    }
}
