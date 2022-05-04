package kz.jusan.spring.bank.cli.jusanspringcli;

// При работе с AccountWithdraw можно снимать и вносить деньги.
public class AccountWithdraw extends Account {
    public AccountWithdraw(AccountType accountType, String id, String clientID, double balance, boolean withdrawAllowed) {
        super(accountType, id, clientID, balance, withdrawAllowed);
    }
}
