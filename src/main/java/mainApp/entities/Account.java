package mainApp.entities;

import javax.persistence.*;
import java.util.UUID;


@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accountId;
    private String accountName;
    private UUID accountNumber;
    private String accountType;
    private Double amount;
    @ManyToOne(targetEntity=AppUser.class, fetch=FetchType.EAGER, cascade = CascadeType.MERGE)
    private AppUser emailId;

    public Account() {
        this.accountNumber = UUID.randomUUID();
    }

    public Account(Long accountId, String accountName, String accountType, Double amount, AppUser appUser) {
        this.accountId = accountId;
        this.accountName = accountName;
        this.accountNumber = UUID.randomUUID();
        this.accountType = accountType;
        this.amount = amount;
        this.emailId = appUser;
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

    public UUID getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(UUID accountNumber) {
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
        return emailId;
    }

    public void setAppUser(AppUser appUser) {
        this.emailId = appUser;
    }
}
