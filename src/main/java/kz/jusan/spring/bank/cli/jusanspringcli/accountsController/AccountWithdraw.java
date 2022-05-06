package kz.jusan.spring.bank.cli.jusanspringcli.accountsController;

import kz.jusan.spring.bank.cli.jusanspringcli.AccountType;
import kz.jusan.spring.bank.cli.jusanspringcli.accountsController.Account;

// При работе с AccountWithdraw можно снимать и вносить деньги.
public class AccountWithdraw extends Account {

    public AccountWithdraw(AccountType accountType, long bankID, long id, String clientID, double balance, boolean withdrawAllowed) {
        super(accountType, bankID, id, clientID, balance, withdrawAllowed);
    }
}
