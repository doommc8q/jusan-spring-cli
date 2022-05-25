package kz.jusan.spring.bank.cli.jusanspringcli.repository;

import kz.jusan.spring.bank.cli.jusanspringcli.entity.Transaction;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionDAO extends CrudRepository<Transaction, String> {
    List<Transaction> findAll();

    @Modifying
    @Query("insert into Transaction values (:transactionId, :clientId, :accountId, :transactionData, :amount, :transactionType, :completed)")
    void createTransaction(String transactionId, String clientId, String accountId, String transactionData, double amount,
                           String transactionType, boolean completed);
}
