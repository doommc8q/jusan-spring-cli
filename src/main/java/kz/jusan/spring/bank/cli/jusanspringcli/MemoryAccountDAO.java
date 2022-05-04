package kz.jusan.spring.bank.cli.jusanspringcli;

import java.util.List;

//  нашем случае, все счета будут храниться в памяти - MemoryAccountDAO.
public class MemoryAccountDAO implements AccountDAO {
    public List<Account> accountList;

    @Override
    public List<Account> getClientAccounts(String clientID) {
        return null;
    }

    @Override
    public void createNewAccount(Account account) {

    }

    @Override
    public void updateAccount(Account account) {

    }

    @Override
    public List<Account> getClientAccountsByType(String clientID, AccountType accountType) {
        return null;
    }

    @Override
    public AccountWithdraw getClientWithdrawAccount(String clientID, String accountID) {
        return null;
    }

    @Override
    public Account getClientAccount(String clientID, String accountID) {
        return null;
    }
}
