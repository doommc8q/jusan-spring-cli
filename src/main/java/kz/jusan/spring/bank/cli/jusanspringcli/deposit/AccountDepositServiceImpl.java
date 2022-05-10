package kz.jusan.spring.bank.cli.jusanspringcli.deposit;

import kz.jusan.spring.bank.cli.jusanspringcli.dao.AccountDAO;
import kz.jusan.spring.bank.cli.jusanspringcli.withdraw.AccountWithdraw;

public class AccountDepositServiceImpl implements AccountDepositService {
    AccountDAO accountDAO;

    @Override
    public void deposit(double amount, AccountWithdraw account) {

    }

    AccountDepositServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }
}
