package kz.jusan.spring.bank.cli.jusanspringcli;

// Saving счетов можно снимать и пополнять
public class SavingAccount extends AccountWithdraw {
    public SavingAccount(AccountType accountType, String id, String clientID, double balance, boolean withdrawAllowed) {
        super(accountType, id, clientID, balance, withdrawAllowed);
    }
}
