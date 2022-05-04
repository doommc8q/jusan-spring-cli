package kz.jusan.spring.bank.cli.jusanspringcli;

// BankCore - это простой класс, который хранит статические значение для нашего банка.
// Дополнительно, у него есть метод для создания счета, который вызывает AccountCreationService.
// AccountID в банке увеличивается при создании новой карты.
public class BankCore {
    private static long id = 1;
    private long lastAccountNumber = 1;
    private AccountCreationService accountCreation;

    public BankCore(AccountCreationService accountCreation) {

    }

    public void createNewAccount(AccountType accountType, String clientID) {
    }

    public void incrementLastAccountNumber() {
    }
}
