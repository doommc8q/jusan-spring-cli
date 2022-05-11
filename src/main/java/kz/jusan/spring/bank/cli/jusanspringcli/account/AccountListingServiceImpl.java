package kz.jusan.spring.bank.cli.jusanspringcli.account;

import kz.jusan.spring.bank.cli.jusanspringcli.accountsType.AccountType;
import kz.jusan.spring.bank.cli.jusanspringcli.dao.AccountDAO;
import kz.jusan.spring.bank.cli.jusanspringcli.withdraw.AccountWithdraw;
import lombok.AllArgsConstructor;

import java.util.List;
@AllArgsConstructor
public class AccountListingServiceImpl implements AccountListingService {
    private final AccountDAO accountDAO;

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
