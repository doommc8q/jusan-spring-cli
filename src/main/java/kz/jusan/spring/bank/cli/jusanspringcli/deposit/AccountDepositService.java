package kz.jusan.spring.bank.cli.jusanspringcli.deposit;

import kz.jusan.spring.bank.cli.jusanspringcli.withdraw.AccountWithdraw;

public interface AccountDepositService {
    void deposit(double amount, AccountWithdraw account);
}
