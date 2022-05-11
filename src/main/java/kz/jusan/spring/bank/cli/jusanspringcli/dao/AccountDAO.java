package kz.jusan.spring.bank.cli.jusanspringcli.dao;

import kz.jusan.spring.bank.cli.jusanspringcli.account.Account;
import kz.jusan.spring.bank.cli.jusanspringcli.accountsType.AccountType;
import kz.jusan.spring.bank.cli.jusanspringcli.withdraw.AccountWithdraw;
import org.springframework.stereotype.Repository;

import java.util.List;

// AccountDAO - это интерфейс, который описывает операции с базой данных
@Repository
public interface AccountDAO {
    List<Account> getClientAccounts(String clientID);

    void createNewAccount(Account account);

    void updateAccount(Account account, Account updatedAccount);

    List<Account> getClientAccountsByType(String clientID, AccountType accountType);

    AccountWithdraw getClientWithdrawAccount(String clientID, String accountID);

    Account getClientAccount(String clientID, String accountID);
}
