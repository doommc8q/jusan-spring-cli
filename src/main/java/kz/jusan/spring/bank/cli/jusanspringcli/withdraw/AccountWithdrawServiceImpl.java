package kz.jusan.spring.bank.cli.jusanspringcli.withdraw;

import kz.jusan.spring.bank.cli.jusanspringcli.dao.AccountDAO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountWithdrawServiceImpl implements AccountWithdrawService {
    AccountDAO accountDAO;

    @Override
    public void withdraw(double amount, AccountWithdraw account) {
        if (account.getBalance() >= amount) {
            accountDAO.updateAccount(account, (-1) * amount);
            System.out.printf("%.2f$ transferred from %03d%06d account\n", amount, account.getBankID(), account.getId());
        } else {
            System.out.println("Not enough money to withdraw");
        }
    }
}
