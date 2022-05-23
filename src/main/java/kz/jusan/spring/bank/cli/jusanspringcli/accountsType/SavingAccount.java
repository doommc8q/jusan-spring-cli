package kz.jusan.spring.bank.cli.jusanspringcli.accountsType;

import kz.jusan.spring.bank.cli.jusanspringcli.accountsType.AccountType;
import kz.jusan.spring.bank.cli.jusanspringcli.withdraw.AccountWithdraw;

// Saving счетов можно снимать и пополнять
public class SavingAccount extends AccountWithdraw {
    public SavingAccount(Long id, AccountType accountType, String clientID, Long bankID, double balance, boolean withdrawAllowed) {
        super(id, accountType, clientID, bankID, balance, withdrawAllowed);
    }
}
