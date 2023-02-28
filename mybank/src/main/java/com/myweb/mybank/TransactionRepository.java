package com.myweb.mybank;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
public interface TransactionRepository extends JpaRepository<Transactions, Long> {
    @Query("SELECT t FROM Transactions t WHERE t.tid = ?1")
    Transactions findByTid(Long tid);
}
