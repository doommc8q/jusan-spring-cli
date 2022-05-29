package kz.jusan.spring.bank.cli.jusanspringcli.repository;

import kz.jusan.spring.bank.cli.jusanspringcli.entity.Transaction;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {
    Iterable<Transaction> findAllByAccountId(Long accountId);


    @Modifying
    @Query("delete from Transaction where account_id = :accountId")
    void deleteByAccountId(Long accountId);
}
