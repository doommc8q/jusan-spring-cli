package kz.jusan.spring.bank.cli.jusanspringcli.withdraw;

import kz.jusan.spring.bank.cli.jusanspringcli.dao.AccountDAO;

public class AccountWithdrawServiceImpl implements AccountWithdrawService{
    AccountDAO accountDAO;
    @Override
    public void deposit(double amount, AccountWithdraw account) {

    }
    AccountWithdrawServiceImpl(AccountDAO accountDAO){
        this.accountDAO = accountDAO;
    }
    void withdraw(double amount, AccountWithdraw account){}

}
