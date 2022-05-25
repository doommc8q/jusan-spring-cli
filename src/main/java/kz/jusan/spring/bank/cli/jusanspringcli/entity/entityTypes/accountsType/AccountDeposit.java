package kz.jusan.spring.bank.cli.jusanspringcli.entity.entityTypes.accountsType;

import kz.jusan.spring.bank.cli.jusanspringcli.entity.Account;

// AccountDeposit можно только снимать
public class AccountDeposit extends Account {
    public AccountDeposit(String id, AccountType accountType, String clientID, Long bankID, double balance, boolean withdrawAllowed) {
        super(id, accountType, clientID, bankID, balance, withdrawAllowed);
    }
}
