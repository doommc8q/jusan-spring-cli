package kz.jusan.spring.bank.cli.jusanspringcli.service.serviceImpl;

import kz.jusan.spring.bank.cli.jusanspringcli.entity.entityTypes.accountsType.AccountWithdraw;
import kz.jusan.spring.bank.cli.jusanspringcli.entity.Account;
import kz.jusan.spring.bank.cli.jusanspringcli.repository.AccountDAO;
import kz.jusan.spring.bank.cli.jusanspringcli.service.AccountWithdrawService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountWithdrawServiceImpl implements AccountWithdrawService {
    @Autowired
    AccountDAO accountDAO;

    @Override
    public boolean withdraw(double amount, AccountWithdraw account) {
        if (account.getBalance() >= amount) {
            double changedBalance = account.getBalance() - amount;
            accountDAO.update(account.getId(), changedBalance);

            Account returnedAccount = accountDAO.findAccountByClientIdAndId(account.getClientId(), account.getId());
            if (returnedAccount.getBalance() == changedBalance) {
                System.out.printf("%.2f$ transferred from %s account\n", amount, account.getId());
                return true;
            } else {
                return false;
            }
        } else {
            System.out.println("Not enough money to withdraw");
            return false;
        }
    }
}
