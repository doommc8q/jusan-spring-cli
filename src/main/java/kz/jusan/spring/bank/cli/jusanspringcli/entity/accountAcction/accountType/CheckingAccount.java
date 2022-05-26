package kz.jusan.spring.bank.cli.jusanspringcli.entity.accountAcction.accountType;

import kz.jusan.spring.bank.cli.jusanspringcli.entity.accountAcction.AccountWithdraw;

// Checking счетов можно снимать и пополнять
public class CheckingAccount extends AccountWithdraw {
    public CheckingAccount(Long accountId, String fullAccountId, Long accountTypeId, String clientId, Long bankId, double balance) {
        super(accountId, fullAccountId, accountTypeId, clientId, bankId, balance);
    }
}
