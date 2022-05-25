package kz.jusan.spring.bank.cli.jusanspringcli.entity.entityTypes.accountsType;

import kz.jusan.spring.bank.cli.jusanspringcli.entity.Account;

// При работе с AccountWithdraw можно снимать и вносить деньги.
public class AccountWithdraw extends Account {

    public AccountWithdraw(String id, AccountType accountType, String clientID, Long bankID, double balance, boolean withdrawAllowed) {
        super(id, accountType, clientID, bankID, balance, withdrawAllowed);
    }
}