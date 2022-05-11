package kz.jusan.spring.bank.cli.jusanspringcli.deposit;

import kz.jusan.spring.bank.cli.jusanspringcli.account.Account;
import kz.jusan.spring.bank.cli.jusanspringcli.withdraw.AccountWithdraw;
import org.springframework.stereotype.Service;

@Service
public interface AccountDepositService {
    void deposit(double amount, Account account);
}
