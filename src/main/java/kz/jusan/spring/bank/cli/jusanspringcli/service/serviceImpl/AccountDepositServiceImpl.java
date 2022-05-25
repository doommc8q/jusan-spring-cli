package kz.jusan.spring.bank.cli.jusanspringcli.service.serviceImpl;

import kz.jusan.spring.bank.cli.jusanspringcli.entity.Account;
import kz.jusan.spring.bank.cli.jusanspringcli.repository.AccountDAO;
import kz.jusan.spring.bank.cli.jusanspringcli.service.AccountDepositService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountDepositServiceImpl implements AccountDepositService {
    final AccountDAO accountDAO;

    @Override
    public boolean deposit(double amount, Account account) {
        double changedBalance =account.getBalance() + amount;
        accountDAO.update(account.getId(), changedBalance);
        Account returnedAccount = accountDAO.findAccountByClientIdAndId(account.getClientId(),account.getId());

        if (returnedAccount.getBalance() == changedBalance) {
            System.out.printf("%.2f$ transferred to %s account\n", amount, account.getId());
            return true;
        } else {
            return false;
        }
    }
}
