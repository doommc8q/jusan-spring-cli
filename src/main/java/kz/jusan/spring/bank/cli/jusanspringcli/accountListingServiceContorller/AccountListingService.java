package kz.jusan.spring.bank.cli.jusanspringcli.accountListingServiceContorller;

import kz.jusan.spring.bank.cli.jusanspringcli.AccountType;
import kz.jusan.spring.bank.cli.jusanspringcli.accountsController.Account;
import kz.jusan.spring.bank.cli.jusanspringcli.accountsController.AccountWithdraw;

import java.util.List;

// AccountListingService отдельный бизнес процесс. имеет интерфейс для изменения данных AccountDAO
public interface AccountListingService {
    Account getClientAccounts(String clientID, String accountID);

    AccountWithdraw getClientWithdrawAccount(String clientID, String accountID);

    List<Account> getClientAccounts(String clientID);

    List<Account> getClientAccountsByType(String clientID, AccountType accountType);
}
