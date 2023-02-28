package com.myweb.mybank;

import org.springframework.beans.factory.annotation.Autowired;

public class TransactionDetailsService {
    @Autowired
    private TransactionRepository repo;
    public TransactionDetails getTransactionDetails(Long tid) throws Exception {
        Transactions transaction = repo.findByTid(tid);
        if(transaction == null) {
            try {
                throw new Exception("Transaction not found");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return new TransactionDetails(transaction);
    }
}
