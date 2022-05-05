package kz.jusan.spring.bank.cli.jusanspringcli;

import java.util.List;

// AccountListingService отдельный бизнес процесс. имеет интерфейс для изменения данных AccountDAO
public interface AccountListingService {
    Account getClientAccounts(String clientID, String accountID);

    AccountWithdraw getClientWithdrawAccount(String clientID, String accountID);

    List<Account> getClientAccounts(String clientID);

    List<Account> getClientAccountsByType(String clientID, AccountType accountType);
}
