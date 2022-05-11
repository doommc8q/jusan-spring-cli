package kz.jusan.spring.bank.cli.jusanspringcli.dao;

import kz.jusan.spring.bank.cli.jusanspringcli.transaction.Transaction;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class MemoryTransactionDAO implements TransactionDAO {
    List<Transaction> transactions = new ArrayList<>();

    @Override
    public List<Transaction> getTransaction() {
        return transactions;
    }

    @Override
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }
}
