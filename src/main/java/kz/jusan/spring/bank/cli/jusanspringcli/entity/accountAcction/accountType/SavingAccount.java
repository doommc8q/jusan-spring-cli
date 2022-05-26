package kz.jusan.spring.bank.cli.jusanspringcli.entity.accountAcction.accountType;

import kz.jusan.spring.bank.cli.jusanspringcli.entity.accountAcction.AccountWithdraw;

// Saving счетов можно снимать и пополнять
public class SavingAccount extends AccountWithdraw {
    public SavingAccount(Long accountId, String fullAccountId, Long accountTypeId, String clientId, Long bankId, double balance) {
        super(accountId, fullAccountId, accountTypeId, clientId, bankId, balance);
    }
}
