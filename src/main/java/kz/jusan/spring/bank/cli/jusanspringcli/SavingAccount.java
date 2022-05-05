package kz.jusan.spring.bank.cli.jusanspringcli;

// Saving счетов можно снимать и пополнять
public class SavingAccount extends AccountWithdraw {
    public SavingAccount(AccountType accountType, long bankID, long id, String clientID, double balance, boolean withdrawAllowed) {
        super(accountType, bankID, id, clientID, balance, withdrawAllowed);
    }
}
