package kz.jusan.spring.bank.cli.jusanspringcli.withdraw;

import kz.jusan.spring.bank.cli.jusanspringcli.dao.AccountDAO;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AccountWithdrawServiceImpl implements AccountWithdrawService {
    AccountDAO accountDAO;

    @Override
    public void deposit(double amount, AccountWithdraw account) {

    }

    void withdraw(double amount, AccountWithdraw account) {
    }

}
