package kz.jusan.spring.bank.cli.jusanspringcli.deposit;

import kz.jusan.spring.bank.cli.jusanspringcli.dao.TransactionDAO;
import kz.jusan.spring.bank.cli.jusanspringcli.withdraw.AccountWithdraw;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TransactionDeposit {
    AccountDepositService accountDepositService;
    TransactionDAO transactionDAO;

    void execute(AccountWithdraw accountWithdraw, double amount) {
    }

}
