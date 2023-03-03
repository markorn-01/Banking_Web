package com.myweb.mybank.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myweb.mybank.model.entities.Transactions;
import com.myweb.mybank.model.models.TransactionModel;
import com.myweb.mybank.model.repositories.TransactionRepository;

@Service
public class TransactionsService {
    @Autowired
    private TransactionRepository repo;
    public TransactionModel getTransactionDetails(Long tid) throws Exception {
        Transactions transaction = repo.findByTid(tid);
        if(transaction == null) {
            try {
                throw new Exception("Transaction not found");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return new TransactionModel(transaction);
    }

    public TransactionModel getTransactionDetailsByUserAccount(Long id) throws Exception {
        Transactions transaction = repo.findByUserAccount(id);
        if(transaction == null) {
            try {
                throw new Exception("Transaction not found");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return new TransactionModel(transaction);
    }
}
