package kz.jusan.spring.bank.cli.jusanspringcli;

// Checking счетов можно снимать и пополнять
public class CheckingAccount extends AccountWithdraw {
    public CheckingAccount(AccountType accountType, String id, String clientID, double balance, boolean withdrawAllowed) {
        super(accountType, id, clientID, balance, withdrawAllowed);
    }
}
