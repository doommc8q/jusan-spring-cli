package kz.jusan.spring.bank.cli.jusanspringcli.deposit;

import kz.jusan.spring.bank.cli.jusanspringcli.account.Account;
import kz.jusan.spring.bank.cli.jusanspringcli.dao.TransactionDAO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TransactionDeposit {
    AccountDepositService accountDepositService;
    TransactionDAO transactionDAO;

    void execute(Account account, double amount) {
        accountDepositService.deposit(amount, account);
    }

}
