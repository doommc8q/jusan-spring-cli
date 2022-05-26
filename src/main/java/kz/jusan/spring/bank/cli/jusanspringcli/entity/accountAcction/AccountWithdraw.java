package kz.jusan.spring.bank.cli.jusanspringcli.entity.accountAcction;

import kz.jusan.spring.bank.cli.jusanspringcli.entity.Account;

// При работе с AccountWithdraw можно снимать и вносить деньги.
public class AccountWithdraw extends Account {
    public AccountWithdraw(Long accountId, String fullAccountId, Long accountTypeId, String clientId, Long bankId, double balance) {
        super(accountId, fullAccountId, accountTypeId, clientId, bankId, balance);
    }
}
