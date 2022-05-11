package kz.jusan.spring.bank.cli.jusanspringcli.dao;

import kz.jusan.spring.bank.cli.jusanspringcli.transaction.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TransactionDAO {
    List<Transaction> getTransaction();

    void addTransaction(Transaction transaction);
}
