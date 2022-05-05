package kz.jusan.spring.bank.cli.jusanspringcli;

import java.util.List;

// AccountDAO - это интерфейс, который описывает операции с базой данных
public interface AccountDAO {
    List<Account> getClientAccounts(String clientID);

    void createNewAccount(Account account);

    void updateAccount(Account account);

    List<Account> getClientAccountsByType(String clientID, AccountType accountType);

    AccountWithdraw getClientWithdrawAccount(String clientID, String accountID);

    Account getClientAccount(String clientID, String accountID);
}
