package kz.jusan.spring.bank.cli.jusanspringcli;

// При работе с AccountWithdraw можно снимать и вносить деньги.
public class AccountWithdraw extends Account {

    public AccountWithdraw(AccountType accountType, long bankID, long id, String clientID, double balance, boolean withdrawAllowed) {
        super(accountType, bankID, id, clientID, balance, withdrawAllowed);
    }
}
