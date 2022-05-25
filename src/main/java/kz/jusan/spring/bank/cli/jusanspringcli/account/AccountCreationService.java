package kz.jusan.spring.bank.cli.jusanspringcli.account;

import kz.jusan.spring.bank.cli.jusanspringcli.accountsType.AccountType;
import org.springframework.stereotype.Service;

// AccountCreationService отдельный бизнес процесс. имеет интерфейс для изменения данных AccountDAO

@Service
public interface AccountCreationService {
    void create(AccountType accountType, Long bankID, String clientID, String accountID);
}
