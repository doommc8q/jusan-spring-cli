package kz.jusan.spring.bank.cli.jusanspringcli.dao;

import kz.jusan.spring.bank.cli.jusanspringcli.transaction.Transaction;

import java.util.List;

public interface TransactionDAO {
    List<Transaction> getTransaction();

    void addTransaction(Transaction transaction);
}
