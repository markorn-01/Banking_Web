package com.myweb.mybank;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

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
        transaction.setDate("2023-28-02");
        transaction.setTransactionType("Transfer");
        Transactions savedTransaction = repo.save(transaction);
        Transactions existTransaction = entityManager.find(Transactions.class, savedTransaction.getTid());
        assertThat(existTransaction.getFromAccount()).isEqualTo(transaction.getFromAccount());
    }

   
}