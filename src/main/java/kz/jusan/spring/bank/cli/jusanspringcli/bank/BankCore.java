package kz.jusan.spring.bank.cli.jusanspringcli.bank;

import kz.jusan.spring.bank.cli.jusanspringcli.account.AccountCreationService;
import kz.jusan.spring.bank.cli.jusanspringcli.accountsType.AccountType;

// BankCore - это простой класс, который хранит статические значение для нашего банка.
// Дополнительно, у него есть метод для создания счета, который вызывает AccountCreationService.
// AccountID в банке увеличивается при создании новой карты.

public class BankCore {
    private static final long id = 1;
    private long lastAccountNumber = 1;
    private final AccountCreationService accountCreation;

    public BankCore(AccountCreationService accountCreation) {
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