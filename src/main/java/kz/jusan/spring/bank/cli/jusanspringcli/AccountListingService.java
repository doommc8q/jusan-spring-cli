package kz.jusan.spring.bank.cli.jusanspringcli;

import java.util.List;

// AccountListingService отдельный бизнес процесс. имеет интерфейс для изменения данных AccountDAO
public interface AccountListingService {
    public Account getClientAccount(String clientID, String accountID);

    public AccountWithdraw getClientWithdrawAccount(String clientID, String accountID);

    public List<Account> getClientAccount(String clientID);

    public List<Account> getClientAccountsByType(String clientID, AccountType accountType);
}
