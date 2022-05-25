package kz.jusan.spring.bank.cli.jusanspringcli.bank;

import kz.jusan.spring.bank.cli.jusanspringcli.account.AccountCreationService;
import kz.jusan.spring.bank.cli.jusanspringcli.accountsType.AccountType;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// BankCore - это простой класс, который хранит статические значение для нашего банка.
// Дополнительно, у него есть метод для создания счета, который вызывает AccountCreationService.
// AccountID в банке увеличивается при создании новой карты.
@Component
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BankCore {
    static final Long bankId = 1L;
    Long lastAccountNumber = 1L;
    final AccountCreationService accountCreation;

    public BankCore(@Qualifier("accountCreationServiceImpl") AccountCreationService accountCreation) {
        this.accountCreation = accountCreation;
    }

    public void createNewAccount(AccountType accountType, String clientID) {
        accountCreation.create(accountType, bankId, clientID, String.format("%03d%06d", bankId, lastAccountNumber));
        incrementLastAccountNumber();
    }

    private void incrementLastAccountNumber() {
        lastAccountNumber++;
    }
}
