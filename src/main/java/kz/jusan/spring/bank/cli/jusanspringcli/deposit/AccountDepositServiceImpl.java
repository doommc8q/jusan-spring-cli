package kz.jusan.spring.bank.cli.jusanspringcli.deposit;

import kz.jusan.spring.bank.cli.jusanspringcli.account.Account;
import kz.jusan.spring.bank.cli.jusanspringcli.dao.AccountDAO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountDepositServiceImpl implements AccountDepositService {
    AccountDAO accountDAO;

    @Override
    public void deposit(double amount, Account account) {
        Account accountDeposit = accountDAO.getClientAccount(account.getClientID(), String.valueOf(account.getId()));
        accountDeposit.setBalance(account.getBalance() + amount);
        accountDAO.updateAccount(account, accountDeposit);
        System.out.printf("%.2f$ transferred from %03d%06d account\n", amount, account.getBankID(), account.getId());
    }
}
