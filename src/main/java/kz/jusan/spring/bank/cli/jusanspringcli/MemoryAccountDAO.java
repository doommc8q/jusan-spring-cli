package kz.jusan.spring.bank.cli.jusanspringcli;

import java.util.ArrayList;
import java.util.List;

//  нашем случае, все счета будут храниться в памяти - MemoryAccountDAO.
public class MemoryAccountDAO implements AccountDAO {
    private List<Account> accountList = new ArrayList<>();

    @Override
    public List<Account> getClientAccounts(String clientID) {
        return accountList;
    }

    @Override
    public void createNewAccount(Account account) {
        if (account == null) {
            System.out.println("Error while creating new account");
            return;
        }
        this.accountList.add(account);
        System.out.println("Bank account created");
    }

    @Override
    public void updateAccount(Account account) {
        if (account == null) {
            System.out.println("Error while creating new account");
            return;
        }
        this.accountList.add(account);
        System.out.println("Account updated");
    }

    @Override
    public List<Account> getClientAccountsByType(String clientID, AccountType accountType) {
        List<Account> clientAccountsByType = new ArrayList<>();
        for (Account a : accountList) {
            if (a.getAccountType() == accountType && a.getClientID().equals(clientID)) {
                clientAccountsByType.add(a);
            }
        }
        return clientAccountsByType;
    }

    @Override
    public AccountWithdraw getClientWithdrawAccount(String clientID, String accountID) {
        System.out.println("Method not expected");
        return null;
    }

    @Override
    public Account getClientAccount(String clientID, String accountID) {
        Account account = null;
        for (Account a : accountList) {
            if (a.getClientID().equals(clientID) && accountID.equals(a.getClientID()))
                account = a;
        }
        return account;
    }
}
