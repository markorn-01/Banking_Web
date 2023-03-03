package com.myweb.mybank.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.myweb.mybank.model.entities.Transactions;
public interface TransactionRepository extends JpaRepository<Transactions, Long> {
    @Query("SELECT t FROM Transactions t WHERE t.tid = ?1")
    Transactions findByTid(Long tid);
    @Query("SELECT t FROM Transactions t WHERE t.fromAccount = ?1 or t.toAccount = ?1")
    Transactions findByUserAccount(Long id);
}
