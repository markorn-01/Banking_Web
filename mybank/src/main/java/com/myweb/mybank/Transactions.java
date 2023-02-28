package com.myweb.mybank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transactions")
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tid;
    @Column(name = "from_account", nullable = false)
    private Long fromAccount;
    @Column(name = "to_account", nullable = false)
    private Long toAccount;
    @Column(name = "amount", nullable = false)
    private Double amount;
    @Column(name = "date", nullable = false)
    private String date;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "transaction_type", nullable = false)
    private String transactionType;
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Long getTid() {
        return tid;
    }
    public void setTid(Long tid) {
        this.tid = tid;
    }
    public Long getFromAccount() {
        return fromAccount;
    }
    public void setFromAccount(Long fromAccount) {
        this.fromAccount = fromAccount;
    }
    public Long getToAccount() {
        return toAccount;
    }
    public void setToAccount(Long toAccount) {
        this.toAccount = toAccount;
    }
    public Double getAmount() {
        return amount;
    }
    public void setAmount(Double amount) {
        this.amount = amount;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }
    public String getTransactionType() {
        return transactionType;
    }
}
