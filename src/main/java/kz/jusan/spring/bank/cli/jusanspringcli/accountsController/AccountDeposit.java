package kz.jusan.spring.bank.cli.jusanspringcli.accountsController;

import kz.jusan.spring.bank.cli.jusanspringcli.AccountType;
import kz.jusan.spring.bank.cli.jusanspringcli.accountsController.Account;

// AccountDeposit можно только снимать
public class AccountDeposit extends Account {
    public AccountDeposit(AccountType accountType, long bankID, long id, String clientID, double balance, boolean withdrawAllowed) {
        super(accountType, bankID, id, clientID, balance, withdrawAllowed);
    }
}
