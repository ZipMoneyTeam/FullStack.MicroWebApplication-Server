package mainApp.entities;

import javax.persistence.*;


@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String accountName;
    Long accountNumber;  // how to increment auto generate
    String accountType;
    Double amount;
    AppUser appUser;

    public Account() {
    }

    public Account(Long id, String accountName, Long accountNumber, String accountType, Double amount, AppUser appUser) {
        this.id = id;
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.amount = amount;
        this.appUser = appUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }
}
