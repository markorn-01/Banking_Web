package com.myweb.mybank.model.models;

import com.myweb.mybank.model.entities.Transactions;

public class TransactionModel {

    private Transactions transaction;

    public TransactionModel(Transactions transaction){
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

    public String getDate() {
        return transaction.getDate();
    }

    public String getDescription() {
        return transaction.getDescription();
    }
    
    public Long getTid() {
        return transaction.getTid();
    }
}
