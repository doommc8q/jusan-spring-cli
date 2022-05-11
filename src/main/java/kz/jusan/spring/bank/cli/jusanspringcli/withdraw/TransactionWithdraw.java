package kz.jusan.spring.bank.cli.jusanspringcli.withdraw;

import kz.jusan.spring.bank.cli.jusanspringcli.dao.TransactionDAO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TransactionWithdraw {
    AccountWithdrawService accountWithdrawService;
    TransactionDAO transactionDAO;

    void execute(AccountWithdraw accountWithdraw, double amount) {
        accountWithdrawService.withdraw(amount, accountWithdraw);

    }
}
