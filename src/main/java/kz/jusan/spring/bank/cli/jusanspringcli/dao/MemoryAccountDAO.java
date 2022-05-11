package kz.jusan.spring.bank.cli.jusanspringcli.dao;

import kz.jusan.spring.bank.cli.jusanspringcli.account.Account;
import kz.jusan.spring.bank.cli.jusanspringcli.accountsType.AccountType;
import kz.jusan.spring.bank.cli.jusanspringcli.withdraw.AccountWithdraw;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

//  нашем случае, все счета будут храниться в памяти - MemoryAccountDAO.
@Repository
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class MemoryAccountDAO implements AccountDAO {
    List<Account> accountList = new ArrayList<>();

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
    public void updateAccount(Account account, Account updatedAccount) {
        accountList.set(accountList.indexOf(account), updatedAccount);
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

        AccountWithdraw account = null;

        for (Account a : accountList) {
            if (String.valueOf(a.getId()).equals(accountID) && a.getClientID().equals(clientID)) {
                account = (AccountWithdraw) a;
            }
        }
        return account;
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
