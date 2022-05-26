package kz.jusan.spring.bank.cli.jusanspringcli.entity.accountAcction.accountType;

import kz.jusan.spring.bank.cli.jusanspringcli.entity.accountAcction.AccountDeposit;

// Fixed счета нельзя снимать деньги
public class FixedAccount extends AccountDeposit {
    public FixedAccount(Long accountId, String fullAccountId, Long accountTypeId, String clientId, Long bankId, double balance) {
        super(accountId, fullAccountId, accountTypeId, clientId, bankId, balance);
    }
}
