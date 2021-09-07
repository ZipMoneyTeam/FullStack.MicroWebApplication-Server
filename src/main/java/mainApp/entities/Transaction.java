package mainApp.entities;

import javax.persistence.*;
import java.time.Instant;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long transactionId;
    String type;
    Boolean status;
    String info;
    Instant date;
    @ManyToOne(targetEntity=Account.class, fetch=FetchType.EAGER)
    Account accountId;

    public Transaction() {
    }

    public Transaction(Long transactionId, String type, Boolean status, String info, Instant date, Account accountId) {
        this.transactionId = transactionId;
        this.type = type;
        this.status = status;
        this.info = info;
        this.date = date;
        this.accountId = accountId;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public Account getAccountId() {
        return accountId;
    }

    public void setAccountId(Account accountId) {
        this.accountId = accountId;
    }
}