package com.myweb.mybank;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.myweb.mybank.model.entities.Transactions;
import com.myweb.mybank.model.repositories.TransactionRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class TransactionRepositoryTests {
    
    @Autowired
    private TransactionRepository repo;
    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateTransaction() {
        Transactions transaction = new Transactions();
        transaction.setFromAccount((long) 1);
        transaction.setToAccount((long) 2);
        transaction.setAmount((double) 1000);
        transaction.setDescription("Transfer 1000 from account 1 to account 2");
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        transaction.setDate(formatter.format(date));
        transaction.setTransactionType("Transfer");
        Transactions savedTransaction = repo.save(transaction);
        Transactions existTransaction = entityManager.find(Transactions.class, savedTransaction.getTid());
        assertThat(existTransaction.getFromAccount()).isEqualTo(transaction.getFromAccount());
    }

    @Test 
    public void testFindTransactionByTid() {
        Long tid = (long) 1;
        Transactions transaction = repo.findByTid(tid);
        assertThat(transaction).isNotNull();
    }

    @Test
    public void testFindTransactionByUserAccount() {
        Long id = (long) 1;
        Transactions transaction = repo.findByUserAccount(id);
        assertThat(transaction).isNotNull();
    }
}