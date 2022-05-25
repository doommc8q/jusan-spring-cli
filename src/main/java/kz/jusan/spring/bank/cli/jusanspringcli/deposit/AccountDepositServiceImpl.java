package kz.jusan.spring.bank.cli.jusanspringcli.deposit;

import kz.jusan.spring.bank.cli.jusanspringcli.account.Account;
import kz.jusan.spring.bank.cli.jusanspringcli.dao.AccountDAO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountDepositServiceImpl implements AccountDepositService {
    final AccountDAO accountDAO;

    @Override
    public void deposit(double amount, Account account) {
        accountDAO.update(account.getId(), account.getBalance() + amount);
        System.out.printf("%.2f$ transferred to %s account\n", amount, account.getId());
    }
}
