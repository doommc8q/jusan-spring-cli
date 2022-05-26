package kz.jusan.spring.bank.cli.jusanspringcli.repository;

import kz.jusan.spring.bank.cli.jusanspringcli.entity.Transaction;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {
    Iterable<Transaction> findAllByAccountId(Long accountId);
}
