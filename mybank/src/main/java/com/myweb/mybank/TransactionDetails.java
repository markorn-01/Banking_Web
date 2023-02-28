package com.myweb.mybank;

import java.util.Date;

public class TransactionDetails {

    private Transactions transaction;

    public TransactionDetails(Transactions transaction){
        this.transaction = transaction;
    }

    public Long getFromAccount() {
        return transaction.getFromAccount();
    }

    public Long getToAccount() {
        return transaction.getToAccount();
    }

    public Double getAmount() {
        return transaction.getAmount();
    }

    public String getTransactionType() {
        return transaction.getTransactionType();
    }

    public Date getDate() {
        return transaction.getDate();
    }

    public String getDescription() {
        return transaction.getDescription();
    }
    
    public Long getTid() {
        return transaction.getTid();
    }
}
