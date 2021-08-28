package mainApp.entities;

import javax.persistence.*;
import java.time.Instant;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String type;
    Boolean status;
    String info;
    Instant date;
    @ManyToOne(targetEntity=Account.class, fetch=FetchType.EAGER)
    Account accountId;

    public Transaction() {
    }

    public Transaction(Long id, String type, Boolean status, String info, Instant date, Account accountId) {
        this.id = id;
        this.type = type;
        this.status = status;
        this.info = info;
        this.date = date;
        this.accountId = accountId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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