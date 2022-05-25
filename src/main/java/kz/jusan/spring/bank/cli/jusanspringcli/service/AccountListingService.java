package kz.jusan.spring.bank.cli.jusanspringcli.service;

import kz.jusan.spring.bank.cli.jusanspringcli.entity.Account;
import kz.jusan.spring.bank.cli.jusanspringcli.entity.entityTypes.accountsType.AccountType;
import kz.jusan.spring.bank.cli.jusanspringcli.entity.entityTypes.accountsType.AccountWithdraw;
import org.springframework.stereotype.Service;

import java.util.List;

// AccountListingService отдельный бизнес процесс. имеет интерфейс для изменения данных AccountDAO
@Service
public interface AccountListingService {
    Account getClientAccounts(String clientID, String accountID);

    AccountWithdraw getClientWithdrawAccount(String clientID, String accountID);

    List<Account> getClientAccounts(String clientID);

    List<Account> getClientAccountsByType(String clientID, AccountType accountType);
}
