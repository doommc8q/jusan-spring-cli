package kz.jusan.spring.bank.cli.jusanspringcli.dao;

import kz.jusan.spring.bank.cli.jusanspringcli.account.Account;
import kz.jusan.spring.bank.cli.jusanspringcli.accountsType.AccountType;
import kz.jusan.spring.bank.cli.jusanspringcli.withdraw.AccountWithdraw;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// AccountDAO - это интерфейс, который описывает операции с базой данных
@Repository
public interface AccountDAO extends CrudRepository<Account, Long> {
    List<Account> findAllByClientId(String clientId);

    @Modifying
    @Query("insert into Account values (:id, :accountType, :clientId, :bankId, :balance, :withdrawAllowed)")
    void createAccount(String id, String accountType, String clientId, Long bankId, double balance, boolean withdrawAllowed);

    @Modifying
    @Query("update Account u set u.balance = :amount where u.id = :id")
    void update(String id, double amount);

    List<Account> findAllByClientIdAndAccountType(String clientId, AccountType accountType);

    @Query("SELECT * FROM Account u WHERE u.client_id = :clientId AND u.id = :accountId AND u.withdraw_allowed = true")
    Account findAccountByWithdrawAccount(String clientId, String accountId);

    Account findAccountByClientIdAndId(String clientId, String id);
}
