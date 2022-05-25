package kz.jusan.spring.bank.cli.jusanspringcli.account;

import kz.jusan.spring.bank.cli.jusanspringcli.accountsType.AccountType;
import kz.jusan.spring.bank.cli.jusanspringcli.dao.AccountDAO;
import kz.jusan.spring.bank.cli.jusanspringcli.withdraw.AccountWithdraw;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@AllArgsConstructor
//@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountListingServiceImpl implements AccountListingService {
    private final AccountDAO accountDAO;

    @Autowired
    public AccountListingServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public Account getClientAccounts(String clientID, String accountID) {
        return accountDAO.findAccountByClientIdAndId(clientID, accountID);
    }

    @Override
    public AccountWithdraw getClientWithdrawAccount(String clientID, String accountID) {
        Account account = accountDAO.findAccountByWithdrawAccount(clientID, accountID);
        return new AccountWithdraw(account.getId(), account.getAccountType(), account.getClientId(), account.getBankId(), account.getBalance(), account.isWithdrawAllowed());
    }

    @Override
    public List<Account> getClientAccounts(String clientID) {
        return this.accountDAO.findAllByClientId(clientID);
    }

    @Override
    public List<Account> getClientAccountsByType(String clientID, AccountType accountType) {
        return accountDAO.findAllByClientIdAndAccountType(clientID, accountType);
    }
}
