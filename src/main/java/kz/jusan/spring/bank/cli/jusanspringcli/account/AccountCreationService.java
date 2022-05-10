package kz.jusan.spring.bank.cli.jusanspringcli.account;

import kz.jusan.spring.bank.cli.jusanspringcli.accountsType.AccountType;

// AccountCreationService отдельный бизнес процесс. имеет интерфейс для изменения данных AccountDAO
public interface AccountCreationService {
    void create(AccountType accountType, long bankID, String clientID, long accountID);
}
