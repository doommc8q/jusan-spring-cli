package kz.jusan.spring.bank.cli.jusanspringcli.deposit;

import kz.jusan.spring.bank.cli.jusanspringcli.dao.AccountDAO;
import kz.jusan.spring.bank.cli.jusanspringcli.withdraw.AccountWithdraw;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AccountDepositServiceImpl implements AccountDepositService {
    AccountDAO accountDAO;

    @Override
    public void deposit(double amount, AccountWithdraw account) {

    }
}
