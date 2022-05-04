package kz.jusan.spring.bank.cli.jusanspringcli;

import java.util.List;

// AccountDAO - это интерфейс, который описывает операции с базой данных
public interface AccountDAO {
    public List<Account> getClientAccounts(String clientID);

    public void createNewAccount(Account account);

    public void updateAccount(Account account);

    public List<Account> getClientAccountsByType(String clientID, AccountType accountType);

    public AccountWithdraw getClientWithdrawAccount(String clientID, String accountID);

    public Account getClientAccount(String clientID, String accountID);
}
