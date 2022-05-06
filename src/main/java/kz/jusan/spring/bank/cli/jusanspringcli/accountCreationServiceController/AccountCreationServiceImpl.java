package kz.jusan.spring.bank.cli.jusanspringcli.accountCreationServiceController;

import kz.jusan.spring.bank.cli.jusanspringcli.AccountType;
import kz.jusan.spring.bank.cli.jusanspringcli.accountsController.Account;
import kz.jusan.spring.bank.cli.jusanspringcli.accountsController.CheckingAccount;
import kz.jusan.spring.bank.cli.jusanspringcli.accountsController.FixedAccount;
import kz.jusan.spring.bank.cli.jusanspringcli.accountsController.SavingAccount;
import kz.jusan.spring.bank.cli.jusanspringcli.daoController.AccountDAO;

public class AccountCreationServiceImpl implements AccountCreationService {
    private AccountDAO accountDAO;

    public AccountCreationServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public void create(AccountType accountType, long bankID, String clientID, long accountID) {
        Account account = null;
        if (accountType.equals(AccountType.SAVING)) {
            account = new SavingAccount(accountType, bankID, accountID, clientID, 0.0, true);
        } else if (accountType.equals(AccountType.FIXED)) {
            account = new FixedAccount(accountType, bankID, accountID, clientID, 0.0, true);
        } else if (accountType.equals(AccountType.CHECKING)) {
            account = new CheckingAccount(accountType, bankID, accountID, clientID, 0.0, true);
        }
        accountDAO.createNewAccount(account);
    }
}
