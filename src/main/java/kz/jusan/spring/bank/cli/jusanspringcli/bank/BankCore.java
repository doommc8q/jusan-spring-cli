package kz.jusan.spring.bank.cli.jusanspringcli.bank;

import kz.jusan.spring.bank.cli.jusanspringcli.account.AccountCreationService;
import kz.jusan.spring.bank.cli.jusanspringcli.accountsType.AccountType;
import lombok.AccessLevel;
import lombok.Value;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

// BankCore - это простой класс, который хранит статические значение для нашего банка.
// Дополнительно, у него есть метод для создания счета, который вызывает AccountCreationService.
// AccountID в банке увеличивается при создании новой карты.
@Service
@FieldDefaults(level= AccessLevel.PRIVATE)
public class BankCore {
    static final long id = 1;
    long lastAccountNumber = 1;
    final AccountCreationService accountCreation;

    public BankCore(@Qualifier("accountCreationServiceImpl") AccountCreationService accountCreation) {
        this.accountCreation = accountCreation;
    }

    public void createNewAccount(AccountType accountType, String clientID) {
        accountCreation.create(accountType, id, clientID, lastAccountNumber);
        incrementLastAccountNumber();
    }

    private void incrementLastAccountNumber() {
        lastAccountNumber++;
    }
}
