package kz.jusan.spring.bank.cli.jusanspringcli.accountListingServiceContorller;

import kz.jusan.spring.bank.cli.jusanspringcli.AccountType;
import kz.jusan.spring.bank.cli.jusanspringcli.accountsController.Account;
import kz.jusan.spring.bank.cli.jusanspringcli.accountsController.AccountWithdraw;
import kz.jusan.spring.bank.cli.jusanspringcli.daoController.AccountDAO;

import java.util.List;

public class AccountListingServiceImpl implements AccountListingService {
    private AccountDAO accountDAO;

    public AccountListingServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public Account getClientAccounts(String clientID, String accountID) {
        return accountDAO.getClientAccount(clientID, accountID);
    }

    @Override
    public AccountWithdraw getClientWithdrawAccount(String clientID, String accountID) {
        return accountDAO.getClientWithdrawAccount(clientID, accountID);
    }

    @Override
    public List<Account> getClientAccounts(String clientID) {
        return this.accountDAO.getClientAccounts(clientID);
    }

    @Override
    public List<Account> getClientAccountsByType(String clientID, AccountType accountType) {
        return accountDAO.getClientAccountsByType(clientID, accountType);
    }
}
