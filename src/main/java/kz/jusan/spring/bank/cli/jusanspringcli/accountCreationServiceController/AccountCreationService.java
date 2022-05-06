package kz.jusan.spring.bank.cli.jusanspringcli.accountCreationServiceController;

import kz.jusan.spring.bank.cli.jusanspringcli.AccountType;

// AccountCreationService отдельный бизнес процесс. имеет интерфейс для изменения данных AccountDAO
public interface AccountCreationService {
    void create(AccountType accountType, long bankID, String clientID, long accountID);
}
