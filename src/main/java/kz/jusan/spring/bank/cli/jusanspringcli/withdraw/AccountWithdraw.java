package kz.jusan.spring.bank.cli.jusanspringcli.withdraw;

import kz.jusan.spring.bank.cli.jusanspringcli.account.Account;
import kz.jusan.spring.bank.cli.jusanspringcli.accountsType.AccountType;

// При работе с AccountWithdraw можно снимать и вносить деньги.
public class AccountWithdraw extends Account {

    public AccountWithdraw(Long id, AccountType accountType, String clientID, Long bankID, double balance, boolean withdrawAllowed) {
        super(id, accountType, clientID, bankID, balance, withdrawAllowed);
    }
}
