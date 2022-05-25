package kz.jusan.spring.bank.cli.jusanspringcli.withdraw;

import kz.jusan.spring.bank.cli.jusanspringcli.dao.AccountDAO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountWithdrawServiceImpl implements AccountWithdrawService {
    @Autowired
    AccountDAO accountDAO;

    @Override
    public void withdraw(double amount, AccountWithdraw account) {
        if (account.getBalance() >= amount) {
            accountDAO.update(account.getId(), account.getBalance() - amount);
            System.out.printf("%.2f$ transferred from %s account\n", amount,  account.getId());
        } else {
            System.out.println("Not enough money to withdraw");
        }
    }
}
