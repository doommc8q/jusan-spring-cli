package kz.jusan.spring.bank.cli.jusanspringcli.accountsType;

import kz.jusan.spring.bank.cli.jusanspringcli.accountsType.AccountType;
import kz.jusan.spring.bank.cli.jusanspringcli.withdraw.AccountWithdraw;

// Checking счетов можно снимать и пополнять
public class CheckingAccount extends AccountWithdraw {
    public CheckingAccount(Long id,AccountType accountType,  String clientID, Long bankID, double balance, boolean withdrawAllowed) {
        super(id,accountType, clientID, bankID, balance, withdrawAllowed);
    }
}
